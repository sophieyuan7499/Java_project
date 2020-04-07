package com.iflytek.bxpt.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import com.iflytek.bxpt.po.Equipment;
import com.iflytek.bxpt.util.DBUtil;
import com.iflytek.bxpt.util.Datetimes;

public class EquipmentDao {
 //根据页面查询所有信息
	 public List<Equipment>  queryAllEquipmentsByPageNo(int pageNo){
		 /*按照分页页码查询数据，我们在pageModel里面设定了每页展示6条数据，这里的集合是为了封装查询的总结果，数据不只一条所以用集合来封装*/
		 List<Equipment> equipments=new ArrayList<>();
		 /*下面的定义变量sql来保存SQL语句*/
		 String sql="select eid,model,number,brands,type,address,buydate,status "
			 		+ "from Equipment_tb,Brands_tb,Status_tb,Type_tb "    /*limit分页关键字*/
			 		+ "where typeid=tid and statusid=sid and brandsid=bid limit "+(pageNo-1)*6+",6";
		 /*将写好的SQL语句进行预编译，调用DBUtil里面的getPreparedStatement（）方法*/
		 PreparedStatement preparedStatement=DBUtil.getPreparedStatement(sql);
		 /*注意这里调用PreparedStatement里面的executeQuery()方法来运行SQL语句，这里是查询，如果是删除和修改，插入则是其他方法，比如：修改是executeUpdate()方法*/
		/* SQL语句在执行的过程中会出现各种错误所以要将编译放在异常处理机制里面执行这样我们就能在后台看到出的什么错*/
		try {
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int eid=resultSet.getInt("eid");
				String model=resultSet.getString("model");
				String number=resultSet.getString("number");
				String brands=resultSet.getString("brands");
				String type=resultSet.getString("type");
				String address=resultSet.getString("address");
				Date buydate=Date.valueOf(resultSet.getString("buydate"));
				String status=resultSet.getString("status");
				Equipment equipment=new Equipment(eid,model, number, address,buydate, status, type,brands);
				equipments.add(equipment);	
				
			}
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeDBResources();
		}		 
		 return equipments;
	 }
	 //根据品牌型号和页面查询所有设备
		public List<Equipment> searchEquipments(String typeid,String model,String statusid,int pageNo){
			List<Equipment > equipments=new ArrayList<>();
			String sql="select eid,model,number,brands,type,address,buydate,status from Equipment_tb,Brands_tb,Status_tb,Type_tb where typeid=tid and statusid=sid and brandsid=bid and typeid=? and statusid=?";
			
			if(model!=null&&model!="") {
				sql=sql+" "+"and model=?";
				System.out.println(sql);
			}	
			sql=sql+" "+"limit"+" "+(pageNo-1)*6+",6";			
			PreparedStatement preparedStatement=DBUtil.getPreparedStatement(sql);
			try {
				
				preparedStatement.setInt(1,Integer.parseInt(typeid));		
				preparedStatement.setInt(2, Integer.parseInt(statusid));
				if(model!=null&&model!="") {
					preparedStatement.setString(3, model);
				}
				ResultSet resultSet =preparedStatement.executeQuery();
				while(resultSet.next()) {
					int eid=resultSet.getInt("eid");
					model=resultSet.getString("model");
					String number=resultSet.getString("number");
					String brands=resultSet.getString("brands");
					String type=resultSet.getString("type");
					String address=resultSet.getString("address");
					Date buydate=Date.valueOf(resultSet.getString("buydate"));
					String status=resultSet.getString("status");
					Equipment equipment=new Equipment(eid,model, number, address,buydate, status, type,brands);
					equipments.add(equipment);				
				}
				resultSet.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				DBUtil.closeDBResources();
			}
			return equipments;
		}
 //查询所有需要报修的物品
	public List<Equipment> queryAllDestoried() {
		List<Equipment> equipments=new ArrayList<>();
		String sql="select eid,model,number,brands,type,address,buydate,status from Equipment_tb, Brands_tb,Status_tb,Type_tb where  typeid=tid and statusid=sid and brandsid=bid and statusid=2 and isrepair=0";
		PreparedStatement preparedStatement=DBUtil.getPreparedStatement(sql);
		try {
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int eid=resultSet.getInt("eid");
				String model=resultSet.getString("model");
				String number=resultSet.getString("number");
				String brands=resultSet.getString("brands");
				String type=resultSet.getString("type");
				String address=resultSet.getString("address");
				Date buydate=Date.valueOf(resultSet.getString("buydate"));
				String status=resultSet.getString("status");
				Equipment equipment=new Equipment(eid,model, number, address,buydate, status, type,brands);
				equipments.add(equipment);	
			}
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeDBResources();
		}
		return equipments;
	}
	//维修处理
	public void isrepair(int eid,String rtime) {
		Datetimes datetimes=new Datetimes();
		String sql="update Equipment_tb set isrepair=1,rtime=? where eid=?";
		PreparedStatement preparedStatement=DBUtil.getPreparedStatement(sql);
	    String time=datetimes.getnow(rtime);
	    System.out.println(time);
		try {
			preparedStatement.setTimestamp(1,Timestamp.valueOf(time));
			preparedStatement.setInt(2, eid);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.closeDBResources();
		}
		
	}
	//查询所有正在维修的物品信息
	public List<Equipment> queryAllRepairs() {
		List<Equipment> equipments=new ArrayList<>();
		String sql="select eid,model,number,brands,type,address,buydate,status from Equipment_tb, Brands_tb,Status_tb,Type_tb where  typeid=tid and statusid=sid and brandsid=bid and statusid=2 and isrepair=1";
		PreparedStatement preparedStatement=DBUtil.getPreparedStatement(sql);
		try {
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int eid=resultSet.getInt("eid");
				String model=resultSet.getString("model");
				String number=resultSet.getString("number");
				String brands=resultSet.getString("brands");
				String type=resultSet.getString("type");
				String address=resultSet.getString("address");
				Date buydate=Date.valueOf(resultSet.getString("buydate"));
				String status=resultSet.getString("status");
				Equipment equipment=new Equipment(eid,model, number, address,buydate, status, type,brands);
				equipments.add(equipment);	
			}
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeDBResources();
		}
		return equipments;
	}
	//查询所有维修记录
	public List<Equipment> queryAllRecords() {
		List<Equipment> equipments=new ArrayList<>();
		String sql="select eid,model,number,brands,type,address,buydate,status,rtime from Equipment_tb, Brands_tb,Status_tb,Type_tb where  typeid=tid and statusid=sid and brandsid=bid and isrepair=1";
		PreparedStatement preparedStatement=DBUtil.getPreparedStatement(sql);
		try {
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int eid=resultSet.getInt("eid");
				String model=resultSet.getString("model");
				String number=resultSet.getString("number");
				String brands=resultSet.getString("brands");
				String type=resultSet.getString("type");
				String address=resultSet.getString("address");
				Date buydate=Date.valueOf(resultSet.getString("buydate"));
				String status=resultSet.getString("status");
				Timestamp rtime=resultSet.getTimestamp("rtime");
				Equipment equipment=new Equipment(eid,model, number, address,buydate, status, type,brands,rtime);
				System.out.println(equipment.getRtime());
				equipments.add(equipment);	
			}
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeDBResources();
		}
		return equipments;
	}
	//维修结果
	public void repairResult(int eid,int statusid) {
		String sql="update Equipment_tb set isrepair=0, statusid=? where eid=?";
		PreparedStatement preparedStatement =DBUtil.getPreparedStatement(sql);
		try {
			preparedStatement.setInt(1, statusid);
			preparedStatement.setInt(2, eid);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
				
	}
	//根据eid来查询记录
	public Equipment queryByEid(int eid) {
		Equipment equipment=null;
		String sql="select eid, model,number,typeid,brandsid,address,buydate,statusid, status, type, brands from Equipment_tb , Brands_tb,Status_tb,Type_tb where typeid=tid and statusid=sid and brandsid=bid and eid=?";
		PreparedStatement preparedStatement=DBUtil.getPreparedStatement(sql);
		try {			
			preparedStatement.setInt(1, eid);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				eid=resultSet.getInt("eid");
				String model=resultSet.getString("model");
				String number=resultSet.getString("number");
				String brands=resultSet.getString("brands");
				int brandsid=Integer.parseInt(resultSet.getString("brandsid"));
				String type=resultSet.getString("type");
				int  typeid=Integer.parseInt(resultSet.getString("typeid"));
				String address=resultSet.getString("address");
				Date buydate=Date.valueOf(resultSet.getString("buydate"));
				String status=resultSet.getString("status");
				int statusid=Integer.parseInt(resultSet.getString("statusid"));
				equipment=new Equipment(eid,model,number,typeid,brandsid,address,buydate,statusid,status,type,brands);					
			}
			resultSet.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.closeDBResources();
		}
		return equipment;
		
	}
 //查询总记录数
		
	public int querytotalRecords() {
		int totalRecords=0;
		String sql="select count(*) as total from Equipment_tb";
		PreparedStatement pstmt = DBUtil.getPreparedStatement(sql);
		try {
			     ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					totalRecords=rs.getInt("total");
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DBUtil.closeDBResources();
			}
			return totalRecords;
		}
	
 //查询搜索结果记录数
	public int querytotalRecords1(String typeid,String model,String statusid) {
		int totalRecords=0;
		String sql="select count(*) as total from Equipment_tb where typeid=? and statusid=?";
		
		if(model!=null||model!="") {
			sql=sql+" "+"and model=?";
		}
	
		PreparedStatement pstmt = DBUtil.getPreparedStatement(sql);
		try {
			pstmt.setInt(1, Integer.parseInt(typeid));
			pstmt.setInt(2,Integer.parseInt(statusid) );
			if(model!=null||model!="") {
				pstmt.setString(3,model);
			}
			     ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					totalRecords=rs.getInt("total");
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DBUtil.closeDBResources();
			}
			return totalRecords;
		}
 //查询所有的商品信息
	 public List<Equipment>  queryAllEquipments(){
		 List<Equipment> equipments=new ArrayList<>();
		 String sql="select eid,model,number,brands,type,address,buydate,status "
		 		+ "from Equipment_tb,Brands_tb,Status_tb,Type_tb "
		 		+ "where typeid=tid and statusid=sid and brandsid=bid";
		 PreparedStatement preparedStatement=DBUtil.getPreparedStatement(sql);
		 try {
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int eid=resultSet.getInt("eid");
				String model=resultSet.getString("model");
				String number=resultSet.getString("number");
				String brands=resultSet.getString("brands");
				String type=resultSet.getString("type");
				String address=resultSet.getString("address");
				Date buydate=Date.valueOf(resultSet.getString("buydate"));
				String status=resultSet.getString("status");
				Equipment equipment=new Equipment(eid,model, number, address,buydate, status, type,brands);
				equipments.add(equipment);
			}
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeDBResources();
		}
		 
		 return equipments;
		 
	 }
	 //添加设备
	 public void addEquipment(Equipment equipment) {
		 String sql="insert into Equipment_tb(model,number,typeid,brandsid,address,buydate,statusid) values(?,?,?,?,?,?,?)";
		 PreparedStatement preparedStatement=DBUtil.getPreparedStatement(sql);
		 try {
				preparedStatement.setString(1, equipment.getModel());
				preparedStatement.setString(2,equipment.getNumber());
				preparedStatement.setInt(3,equipment.getTypeid());
				preparedStatement.setInt(4, equipment.getBrandsid());
				preparedStatement.setString(5, equipment.getAddress());
				preparedStatement.setDate(6, equipment.getBuydate());
				preparedStatement.setInt(7, equipment.getStatusid());
	            preparedStatement.executeUpdate();
     	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeDBResources();
		}
	 }
	 //修改设备信息
	public void updateEquipment(Equipment equipment) {
		String sql="update Equipment_tb set model=?,number=?,typeid=?,brandsid=?,address=?,buydate=?,statusid=? where eid=?";
		PreparedStatement preparedStatement=DBUtil.getPreparedStatement(sql);
		try {
			preparedStatement.setString(1, equipment.getModel());
			preparedStatement.setString(2,equipment.getNumber());
			preparedStatement.setInt(3,equipment.getTypeid());
			preparedStatement.setInt(4, equipment.getBrandsid());
			preparedStatement.setString(5, equipment.getAddress());
			preparedStatement.setDate(6, equipment.getBuydate());
			preparedStatement.setInt(7, equipment.getStatusid());
			preparedStatement.setInt(8, equipment.getEid());
            preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.closeDBResources();
		}
		
		
	} 
	//删除设备信息
	public void deleteEquipment(int eid) {
		String sql="delete from Equipment_tb where eid=?";
		PreparedStatement preparedStatement=DBUtil.getPreparedStatement(sql);
		try {
			preparedStatement.setInt(1, eid);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		   e.printStackTrace();
		}finally {
			DBUtil.closeDBResources();
		}
		
	}
	//不使用分页查询出所有满足条件的物品信息
/*	public List<Equipment> searchEquipment(String typeid,String brandsid){
		List<Equipment > equipments=new ArrayList<>();
		String sql="select eid,model,number,brands,type,address,buydate,status"
		        + "from Equipment_tb,Brands_tb,Status_tb,Type_tb "
		 		+ "where typeid=tid and statusid=sid and brandsid=bid ";
		if(typeid!=null||typeid!="") {
			sql=sql+"and typeid=?";	
		}
		if(brandsid!=null||brandsid!="") {
			sql=sql+"and brandsid=?";
		}
		PreparedStatement preparedStatement=DBUtil.getPreparedStatement(sql);
		try {
			ResultSet resultSet =preparedStatement.executeQuery();
			preparedStatement.setInt(1,Integer.parseInt(typeid));
			preparedStatement.setInt(2, Integer.parseInt(brandsid));
			while(resultSet.next()) {
				int eid=resultSet.getInt("eid");
				String model=resultSet.getString("model");
				String number=resultSet.getString("number");
				String brands=resultSet.getString("brands");
				String type=resultSet.getString("type");
				String address=resultSet.getString("address");
				Date buydate=Date.valueOf(resultSet.getString("buydate"));
				String status=resultSet.getString("status");
				Equipment equipment=new Equipment(eid,model, number, address,buydate, status, type,brands);
				equipments.add(equipment);				
			}
			resultSet.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.closeDBResources();
		}
		return equipments;
	}*/
}
