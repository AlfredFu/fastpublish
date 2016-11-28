package me.wmn.designpattern.chainofresp;

public class Leader extends Employee implements IClaim, IClaimApprove{

	@Override
	public void claim() {
//		if(req.getAmount() > 50000){
//			//need Director to approve
//			
//			
//		}else if(req.getAmount() >10000){
//			//need Manager to approve
//			
//		}else{
//			//Leader is authorized to approve
//		}
	
	}

	@Override
	public boolean approve(Request req) {
		return false;
	}


}
