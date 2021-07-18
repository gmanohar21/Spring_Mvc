package com.mn.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.mn.model.caronavac;

@Component("excel_view")
public class ExcelView extends AbstractXlsView {
	private static int i = 0;

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		List<caronavac> vac = (List<caronavac>) model.get("vacList");
		Sheet sh = workbook.createSheet("sheet1");

		vac.forEach(vacs -> {
			Row row = sh.createRow(i);
			row.createCell(0).setCellValue(vacs.getName());
			row.createCell(1).setCellValue(vacs.getCompany());
			row.createCell(2).setCellValue(vacs.getPrice());
			i++;
		});

	}

}
