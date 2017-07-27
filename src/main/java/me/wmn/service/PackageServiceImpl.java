package me.wmn.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import me.wmn.domain.OSPackage;
import me.wmn.domain.Version;
import me.wmn.persistence.IPackageDao;
import me.wmn.persistence.IVersionDao;

@Service
public class PackageServiceImpl implements IPackageService{
	
	private final String PACKAGE_NAME_PATTERN = "%s_%s_%s_%s_%d.%s";
	
	@Autowired
	private IPackageDao packageDao;
	
	@Autowired
	private IVersionDao versionDao;
	
	@Value("${attachment.folder}")
	private String uploadFolder;
	
	@Override
	public void addPackage(OSPackage osp) {
		this.packageDao.savePackage(osp);
	}
	
//	@Transactional(rollbackFor={java.io.IOException.class})
	public OSPackage uploadPackage(int versionId, OSPackage osp, MultipartFile ospackageFile) throws IOException{
		Version v = versionDao.getById(versionId);
		String[] tmpNames = ospackageFile.getOriginalFilename().split("\\.");
		String targetPackageName = getPackageName("Lexis_Red", osp.getOsType().toString(), v.getVersionType().toString(), v.getName(), v.getBuild(), tmpNames[tmpNames.length -1]);

		String absFilePath = this.uploadFolder + targetPackageName;
		File osPackageFile = new File(absFilePath);
		
		//persist package info to database
		osp.setPackageName(targetPackageName);
		osp.setProductId(v.getProductId());
		this.addPackage(osp);
		
		//TODO，使用以下代码代替FileUtils写文件
		//ospackageFile.transferTo(new File(""));
		if(!osPackageFile.exists()){
			osPackageFile.createNewFile();
		}
		FileUtils.writeByteArrayToFile(osPackageFile, ospackageFile.getBytes());
		
		
		return osp;
	}

	@Override
	public void deleteById(int id) {
		OSPackage osp = this.getById(id);
		if(osp != null){
			FileUtils.deleteQuietly(new File(this.uploadFolder + osp.getPackageName()));
			this.packageDao.deleteById(id);
		}
	}

	public IPackageDao getPackageDao() {
		return packageDao;
	}

	public void setPackageDao(IPackageDao packageDao) {
		this.packageDao = packageDao;
	}

	@Override
	public List<OSPackage> getByProductId(int productId) {
		return this.packageDao.getByProductId(productId);
	}

	@Override
	public String getPackageName(String productName, String osType, String versionType, String versionName, int build, String suffix) {
		return String.format(this.PACKAGE_NAME_PATTERN, productName, osType, versionType, versionName, build, suffix);
	}
	
	public OSPackage getById(int id){
		return this.packageDao.getById(id);
	}

	public String getUploadFolder() {
		return uploadFolder;
	}

	public void setUploadFolder(String uploadFolder) {
		this.uploadFolder = uploadFolder;
	}

	public IVersionDao getVersionDao() {
		return versionDao;
	}

	public void setVersionDao(IVersionDao versionDao) {
		this.versionDao = versionDao;
	}
	
	
}
