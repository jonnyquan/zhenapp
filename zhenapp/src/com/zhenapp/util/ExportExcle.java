package com.zhenapp.util;


public class ExportExcle {
	/*
	public void ExprotExcle(List<DatacountInfoCustom> list,String filepath){
		// 第一步，创建一个webbook，对应一个Excel文件  
        HSSFWorkbook wb = new HSSFWorkbook();  
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
        HSSFSheet sheet = wb.createSheet("数据统计");  
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
        HSSFRow row = sheet.createRow((int) 0);  
        // 第四步，创建单元格，并设置值表头 设置表头居中  
        HSSFCellStyle style = wb.createCellStyle();  
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式  
  
        HSSFCell cell = row.createCell((short) 0);  
        cell.setCellValue("日期");  
        cell.setCellStyle(style);  
        cell = row.createCell((short) 1);  
        cell.setCellValue("访问量");  
        cell.setCellStyle(style);  
        cell = row.createCell((short) 2);  
        cell.setCellValue("收藏量");  
        cell.setCellStyle(style);  
        cell = row.createCell((short) 3);  
        cell.setCellValue("购物车量");  
        cell.setCellStyle(style);
        cell = row.createCell((short) 4);  
        cell.setCellValue("购买积分");  
        cell.setCellStyle(style);
        cell = row.createCell((short) 5);  
        cell.setCellValue("消耗积分");  
        cell.setCellStyle(style);
        cell = row.createCell((short) 6);  
        cell.setCellValue("后台操作");  
        cell.setCellStyle(style);
  
        // 第五步，写入实体数据 实际应用中这些数据从数据库得到，   
        for (int i = 0; i < list.size(); i++)  
        {  
            row = sheet.createRow((int) i + 1);  
            DatacountInfoCustom datacountInfoCustom = (DatacountInfoCustom) list.get(i);  
            // 第四步，创建单元格，并设置值  
            row.createCell((short) 0).setCellValue(datacountInfoCustom.getDate());  
            row.createCell((short) 1).setCellValue(datacountInfoCustom.getFinishcount());  
            row.createCell((short) 2).setCellValue(datacountInfoCustom.getCollectioncount());
            row.createCell((short) 3).setCellValue(datacountInfoCustom.getShoppingcount());
            row.createCell((short) 4).setCellValue(datacountInfoCustom.getBuypoints());
            row.createCell((short) 5).setCellValue(datacountInfoCustom.getExpendpoints());
            row.createCell((short) 6).setCellValue("0");
           // cell = row.createCell((short) 3);  
           // cell.setCellValue(new SimpleDateFormat("yyyy-mm-dd").format(stu  
           //         .getBirth()));  
        }  
        // 第六步，将文件存到指定位置  
        try  
        {  
            FileOutputStream fout = new FileOutputStream(filepath+"/datacountInfoCustom.xls");  
            wb.write(fout);  
            fout.close();  
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();
        }
	}
	*/
}
