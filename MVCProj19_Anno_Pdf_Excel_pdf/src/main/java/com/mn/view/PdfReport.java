package com.mn.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.mn.model.caronavac;

@Component("pdf_view")
public class PdfReport extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, com.lowagie.text.Document document,
			com.lowagie.text.pdf.PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("PdfReport.buildPdfDocument()");
		List<caronavac> vac = (List<caronavac>) model.get("vacList");
		Paragraph p = new Paragraph("Vaccine Report");
		document.add(p);
		Table table = new Table(3, vac.size());
		for (caronavac caronav : vac) {
			table.addCell(caronav.getName());
			table.addCell(caronav.getCompany());
			table.addCell(String.valueOf(caronav.getPrice()));
		}
		document.add(table);

	}

}
