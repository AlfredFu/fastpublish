package me.wmn.persistence.jdbcimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import me.wmn.domain.Version;
import me.wmn.domain.VersionTypeEnum;
import me.wmn.persistence.IVersionDao;

@Component
public class JdbcVersionDao implements IVersionDao{


	@Autowired NamedParameterJdbcTemplate npJdbcTemplate;
	
	public List<Version> getByProductID(Integer productID) {
		if(productID != null){
			final String sql = "SELECT * FROM version WHERE product_id=:product_id ORDER BY create_datetime DESC";
			HashMap<String, Integer> paramMap = new HashMap<String, Integer>();
			paramMap.put("product_id", productID);
			List<Version> versions = this.npJdbcTemplate.query(sql, paramMap, new RowMapper<Version>(){

				public Version mapRow(ResultSet rs, int rowNum) throws SQLException {
					Version v = new Version();
					v.setId(rs.getInt("id"));
					v.setName(rs.getString("name"));
					v.setVersionType(VersionTypeEnum.valueOf(rs.getString("version_type")));
					v.setProductId(rs.getInt("product_id"));
					v.setCreateDate(rs.getDate("create_datetime"));
					return v;
				}
			});
			return versions;
		}
		return null;
	}

	public void saveVersion(Version version) {
		if(version != null){
			final String sql = "INSERT INTO version(name, version_type, product_id) values(:name, :version_type, :product_id)";
			HashMap<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("name", version.getName());
			paramMap.put("version_type", version.getVersionType().toString());
			paramMap.put("product_id", version.getProductId());
			this.npJdbcTemplate.update(sql, paramMap);
		}	
	}

	@Override
	public Version getById(Integer id) {
		final String sql = "SELECT * FROM version WHERE id=:id";
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		Version v = this.npJdbcTemplate.query(sql, paramMap, new ResultSetExtractor<Version>(){

			@Override
			public Version extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()){
					Version v = new Version();
					
					v.setId(rs.getInt("id"));
					v.setName(rs.getString("name"));
					v.setVersionType(VersionTypeEnum.valueOf(rs.getString("version_type")));
					v.setProductId(rs.getInt("product_id"));
					v.setCreateDate(rs.getDate("create_datetime"));
					return v;
				}
				return null;
			}
			
		});
		return v;
	}
	
	@Override
	public void deleteById(int id){
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		this.npJdbcTemplate.update("DELETE FROM version WHERE id=:id", paramMap);
	}
	
	

}
