package tn.esprit.services;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import tn.esprit.entities.Forum;
import tn.esprit.entities.Quizz;
import tn.esprit.repositories.QuizzRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.*;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PdfServiceImpl implements IPdfService {


	@Autowired
	QuizzServiceImpl quizz;
	@Autowired
	QuizzRepo qr;

	@Override
	public String toPDF(int id) {
		String URL_file = null;
		Quizz q=new Quizz();
		q=qr.getById(id);
		
		 Date d = new Date();
         SimpleDateFormat formater = null;
         formater = new SimpleDateFormat("yyyyMMdd_HHmmss");

		try {
			try {
				try {
					try {

	                        URL_file = "./src/main/resources/" +"_"+formater.format(d)+".pdf";
	                        OutputStream file = new FileOutputStream(new File(URL_file));
//	                        Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD, BaseColor.DARK_GRAY);
//	                        Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD, BaseColor.RED);
	                        Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.GRAY);
	                        Font catFont15B = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD, BaseColor.BLACK);
//	                        Font catFont17B = new Font(Font.FontFamily.TIMES_ROMAN, 17, Font.BOLD, BaseColor.BLACK);
	                        Font catFont17Bcour = new Font(Font.FontFamily.COURIER, 17, Font.BOLD, BaseColor.BLACK);
//	                        Font catFont14N = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.NORMAL, BaseColor.BLACK);
//	                        Font catFont14B = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD, BaseColor.BLACK);
//	                        Font catFont14Bcour = new Font(Font.FontFamily.COURIER, 14, Font.BOLD, BaseColor.BLACK);
	                        Font subFontPara13B = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD, BaseColor.BLACK);
//	                        Font subFontPara12Ncour = new Font(Font.FontFamily.COURIER, 12, Font.NORMAL, BaseColor.BLACK);
//	                        Font subFontPara12CScour = new Font(Font.FontFamily.COURIER, 14, Font.UNDERLINE | Font.BOLD , BaseColor.BLACK);
//	                        Font subFontPara12Bcour = new Font(Font.FontFamily.COURIER, 12, Font.BOLD , BaseColor.BLACK);
	                        Font subFontPara13N= new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.NORMAL, BaseColor.BLACK);
	                        Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.BOLD);

	                        Document my_pdf_report = new Document();
	                        PdfWriter.getInstance(my_pdf_report, file);
	                        my_pdf_report.open();


	                        ///Imageee
	                        Image imgBank = null;
	                     /*   if (simulation.getBank().getName().equals("UIB")){
	                         imgBank = Image.getInstance("C:\\Users\\ASUS\\Documents\\Bank\\uib.jpg");}

	                        if (simulation.getBank().getName().equals("BIAT")){
		                      imgBank = Image.getInstance("C:\\Users\\ASUS\\Documents\\Bank\\biat.jpg");}

	                        if (simulation.getBank().getName().equals("UBCI")){
			                      imgBank = Image.getInstance("C:\\Users\\ASUS\\Documents\\Bank\\ubci.jpg");}

	                        if (simulation.getBank().getName().equals("ATTIJARI")){
			                      imgBank = Image.getInstance("C:\\Users\\ASUS\\Documents\\Bank\\attijari.jpg");}
	                        */
	                        //767
	                       // imgBank.setAbsolutePosition(50,769);
	                       // imgBank.scaleAbsolute(70,50);

	                        //Dateeee
	                        DateFormat df = new SimpleDateFormat("dd MMMM yyyy");
	                        String dt = df.format(new Date());
	                        Paragraph dateStr = new Paragraph(dt, catFont15B);
		                      //separator
	                        Paragraph separator1 = new Paragraph("_______________________________________________________________________________" , subFontPara13N);

	                        Paragraph titre=new Paragraph("ESTIMATION_"+ "_"+formater.format(d));
	                        Paragraph titreBank = new Paragraph(" BANK",catFont15B);
	                        dateStr.setAlignment(Element.ALIGN_RIGHT);
	                        //titreBank.setAlignment(Element.ALIGN_RIGHT);
	                        separator1.setAlignment(Element.ALIGN_RIGHT);
	                        titre.setAlignment(Element.ALIGN_RIGHT);


	                      //espaceee
	                        Paragraph espace = new Paragraph(" ", subFont);
	                        espace.setAlignment(Element.ALIGN_LEFT);

	                        //para1
	                        Paragraph para1 = new Paragraph("Miss/Mr " , catFont15B);
	                        para1.setAlignment(Element.ALIGN_LEFT);
	                        Paragraph para2 = new Paragraph("We are happy for your trust and we hope you are doing well. We provide you"
	                        		+ " a List of Quizzes ." , subFontPara13N);
	                        para2.setAlignment(Element.ALIGN_LEFT);


	                      //titreee
	                        Paragraph titre1 = new Paragraph("DETAILS ABOUT The Quizz" , catFont15B);
	                        titre1.setAlignment(Element.ALIGN_CENTER);


	                        PdfPTable table = new PdfPTable(4);
	                        table.setWidthPercentage(90);
	                        table.setHorizontalAlignment(Element.ALIGN_LEFT);;

	                        ///Ligne 1
	                        PdfPCell  Cellnom = new PdfPCell(new Phrase("ID", subFontPara13B));
	                        Cellnom.setBorder(Rectangle.NO_BORDER);
	                        Cellnom.setBackgroundColor(BaseColor.WHITE);

	                        PdfPCell CellnomR = new PdfPCell(new Phrase( ": "+q.getId()  , subFontPara13N));
	                        CellnomR.setBorder(Rectangle.NO_BORDER);
	                        CellnomR.setBackgroundColor(BaseColor.WHITE);
	                        CellnomR.setColspan(3);


	                        table.addCell(Cellnom);
	                        table.addCell(CellnomR);

	                        PdfPCell CellnomRN = new PdfPCell( new Phrase(""));
	                        CellnomRN.setBorder(Rectangle.NO_BORDER);
	                        CellnomRN.setBackgroundColor(BaseColor.WHITE);

	                        //space
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);


	                    /////Ligne 2
	                        PdfPCell  CellCin = new PdfPCell(new Phrase("question number", subFontPara13B));
	                        CellCin.setBorder(Rectangle.NO_BORDER);
	                        CellCin.setBackgroundColor(BaseColor.WHITE);

	                        PdfPCell CellCinR = new PdfPCell(new Phrase( ": "+q.getQuestionnumber(), subFontPara13N));
	                        CellCinR.setBorder(Rectangle.NO_BORDER);
	                        CellCinR.setBackgroundColor(BaseColor.WHITE);
	                        CellCinR.setColspan(3);

	                        table.addCell(CellCin);
	                        table.addCell(CellCinR);

	                        //space
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);

	                    /////Ligne 3
	                        PdfPCell  CellEmail = new PdfPCell(new Phrase("Description", subFontPara13B));
	                        CellEmail.setBorder(Rectangle.NO_BORDER);
	                        CellEmail.setBackgroundColor(BaseColor.WHITE);


	                        PdfPCell CellEmailR = new PdfPCell(new Phrase( ": " +q.getDescription(), subFontPara13N));
	                        CellEmailR.setBorder(Rectangle.NO_BORDER);
	                        CellEmailR.setBackgroundColor(BaseColor.WHITE);
	                        CellEmailR.setColspan(3);


	                        table.addCell(CellEmail);
	                        table.addCell(CellEmailR);


	                        //space
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);
	                        table.addCell(CellnomRN);



//	                        /////Ligne 4
//	                        PdfPCell  CelAdr = new PdfPCell(new Phrase("Téléphone", subFontPara13B));
//	                        CelAdr.setBorder(Rectangle.NO_BORDER);
//	                        CelAdr.setBackgroundColor(BaseColor.WHITE);
//
//	                        PdfPCell CelAdrr = new PdfPCell(new Phrase( ": " +simulation.getClient().get , subFontPara13N));
//	                        CelAdrr.setBorder(Rectangle.NO_BORDER);
//	                        CelAdrr.setBackgroundColor(BaseColor.WHITE);
//	                        CelAdrr.setColspan(3);
//
//	                        table.addCell(CelAdr);
//	                        table.addCell(CelAdrr);


//	                        //space
//	                        table.addCell(CellnomRN);
//	                        table.addCell(CellnomRN);
//	                        table.addCell(CellnomRN);
//	                        table.addCell(CellnomRN);
//	                        table.addCell(CellnomRN);
//	                        table.addCell(CellnomRN);
//	                        table.addCell(CellnomRN);
//	                        table.addCell(CellnomRN);




//	                        /////Ligne 5
//	                        PdfPCell  Celjob = new PdfPCell(new Phrase("Profession ", subFontPara13B));
//	                        Celjob.setBorder(Rectangle.NO_BORDER);
//	                        Celjob.setBackgroundColor(BaseColor.WHITE);
//
//	                        PdfPCell Celjobb = new PdfPCell(new Phrase( ": " +c.getCustomer().getJob(), subFontPara13N));
//	                        Celjobb.setBorder(Rectangle.NO_BORDER);
//	                        Celjobb.setBackgroundColor(BaseColor.WHITE);
//	                        Celjobb.setColspan(3);
//
//	                        table.addCell(Celjob);
//	                        table.addCell(Celjobb);
//
//
//	                        //space
//	                        table.addCell(CellnomRN);
//	                        table.addCell(CellnomRN);
//	                        table.addCell(CellnomRN);
//	                        table.addCell(CellnomRN);
//	                        table.addCell(CellnomRN);
//	                        table.addCell(CellnomRN);
//	                        table.addCell(CellnomRN);
//	                        table.addCell(CellnomRN);


	                   
	                      //separator
	                       
	                      //fiin P1
	                        Paragraph finPage1 = new Paragraph(" WellBeing Group (c) 2022" , smallBold);
	                        finPage1.setAlignment(Element.ALIGN_RIGHT);

/////////////////////











//                        ///////table 1
//                        PdfPTable tableLog = new PdfPTable(4);
//                        tableLog.setWidthPercentage(50);
//                        PdfPCell  Celog = new PdfPCell(new Phrase("Rate", catFont14Bcour));
//                        Celog.setPadding(12);
//                        Celog.setColspan(2);
//                        Celog.setHorizontalAlignment(Element.ALIGN_RIGHT);
//                        Celog.setVerticalAlignment(Element.ALIGN_RIGHT);
//
//                        PdfPCell Celogr = new PdfPCell(new Phrase( "" +simulation.getTaux() , subFontPara13N));
//                        Celogr.setPadding(12);
//                        Celogr.setColspan(2);
//
//                        Celogr.setHorizontalAlignment(Element.ALIGN_RIGHT);
//                        Celogr.setVerticalAlignment(Element.ALIGN_RIGHT);
//
//                        tableLog.addCell(Celog);
//                        tableLog.addCell(Celogr);
//
//
//                  ///////table 2
//                        PdfPTable tabletm = new PdfPTable(4);
//                        tabletm.setWidthPercentage(50);
//
//                        PdfPCell  Celtm1 = new PdfPCell(new Phrase("Monthly rate", catFont14Bcour));
//                        Celtm1.setPadding(12);
//                        Celtm1.setHorizontalAlignment(Element.ALIGN_RIGHT);
//                        Celtm1.setVerticalAlignment(Element.ALIGN_RIGHT);
//                        Celtm1.setColspan(2);
//
//                        PdfPCell Celtmm1 = new PdfPCell(new Phrase( "" +simulation.getMensuel() , subFontPara13N));
//                        Celtmm1.setPadding(12);
//                        Celtmm1.setColspan(2);
//                        Celtmm1.setHorizontalAlignment(Element.ALIGN_RIGHT);
//                        Celtmm1.setVerticalAlignment(Element.ALIGN_RIGHT);
//
//                        tabletm.addCell(Celtm1);
//                        tabletm.addCell(Celtmm1);
//
////                        ///////table 3
////                        PdfPTable tableEch = new PdfPTable(4);
////                        tableEch.setWidthPercentage(50);
////
////                        PdfPCell  Celech = new PdfPCell(new Phrase("Nombre D'echeance", catFont14Bcour));
////                        Celech.setPadding(12);
////                        Celech.setColspan(2);
////                        Celech.setHorizontalAlignment(Element.ALIGN_CENTER);
////                        Celech.setVerticalAlignment(Element.ALIGN_MIDDLE);
////
////                        PdfPCell Celechh = new PdfPCell(new Phrase( "" +estimation.getNombreEcheance() , subFontPara13N));
////                        Celechh.setPadding(12);
////                        Celechh.setColspan(2);
////                        Celechh.setHorizontalAlignment(Element.ALIGN_CENTER);
////                        Celechh.setVerticalAlignment(Element.ALIGN_MIDDLE);
////
////                        tableEch.addCell(Celech);
////                        tableEch.addCell(Celechh);
//
//                  ///////table 4
//                        PdfPTable tableCap = new PdfPTable(4);
//                        tableCap.setWidthPercentage(50);
//
//                        PdfPCell  CelCapR = new PdfPCell(new Phrase("Repayment Capacity", catFont14Bcour));
//                        CelCapR.setPadding(12);
//                        CelCapR.setColspan(2);
//                        CelCapR.setHorizontalAlignment(Element.ALIGN_RIGHT);
//                        CelCapR.setVerticalAlignment(Element.ALIGN_RIGHT);
//
//                        PdfPCell CelCapRr = new PdfPCell(new Phrase( "" +simulation.getCapaciteDeRembouresement() , subFontPara13N));
//                        CelCapRr.setPadding(12);
//                        CelCapRr.setColspan(2);
//                        CelCapRr.setHorizontalAlignment(Element.ALIGN_RIGHT);
//                        CelCapRr.setVerticalAlignment(Element.ALIGN_RIGHT);
//
//                        tableCap.addCell(CelCapR);
//                        tableCap.addCell(CelCapRr);
//
//                  ///////table 5
//                        PdfPTable tableMens = new PdfPTable(4);
//                        tableMens.setWidthPercentage(50);
//
//                        PdfPCell  CelMens = new PdfPCell(new Phrase("Monthly Payment", catFont14Bcour));
//                        CelMens.setPadding(12);
//                        CelMens.setColspan(2);
//                        CelMens.setHorizontalAlignment(Element.ALIGN_RIGHT);
//                        CelMens.setVerticalAlignment(Element.ALIGN_MIDDLE);
//
//                        PdfPCell CelMenss = new PdfPCell(new Phrase( "" +simulation.getMensualite() , subFontPara13N));
//                        CelMenss.setPadding(12);
//                        CelMenss.setColspan(2);
//                        CelMenss.setHorizontalAlignment(Element.ALIGN_RIGHT);
//                        CelMenss.setVerticalAlignment(Element.ALIGN_RIGHT);
//
//                        tableMens.addCell(CelMens);
//                        tableMens.addCell(CelMenss);
//
//
//                  ///////table 6
//                        PdfPTable tableInteret = new PdfPTable(4);
//                        tableInteret.setWidthPercentage(50);
//
//                        PdfPCell  CelInt = new PdfPCell(new Phrase("Interest", catFont14Bcour));
//                        CelInt.setPadding(12);
//                        CelInt.setColspan(2);
//                        CelInt.setHorizontalAlignment(Element.ALIGN_RIGHT);
//                        CelInt.setVerticalAlignment(Element.ALIGN_RIGHT);
//
//                        PdfPCell CelIntt = new PdfPCell(new Phrase( "" +simulation.getInteret() , subFontPara13N));
//                        CelIntt.setPadding(12);
//                        CelIntt.setColspan(2);
//                        CelIntt.setHorizontalAlignment(Element.ALIGN_RIGHT);
//                        CelIntt.setVerticalAlignment(Element.ALIGN_RIGHT);
//
//                        tableInteret.addCell(CelInt);
//                        tableInteret.addCell(CelIntt);
//
//
//                        ///////table 7
//                        PdfPTable tablePrincper = new PdfPTable(4);
//                        tablePrincper.setWidthPercentage(50);
//
//                        PdfPCell  CelPrincper = new PdfPCell(new Phrase("Princper", catFont14Bcour));
//                        CelPrincper.setPadding(12);
//                        CelPrincper.setColspan(2);
//                        CelPrincper.setHorizontalAlignment(Element.ALIGN_RIGHT);
//                        CelPrincper.setVerticalAlignment(Element.ALIGN_RIGHT);
//
//                        PdfPCell CelPrincperr = new PdfPCell(new Phrase( "" +simulation.getPrincipale() , subFontPara13N));
//                        CelPrincperr.setPadding(12);
//                        CelPrincperr.setColspan(2);
//                        CelPrincperr.setHorizontalAlignment(Element.ALIGN_RIGHT);
//                        CelPrincperr.setVerticalAlignment(Element.ALIGN_RIGHT);
//
//                        tablePrincper.addCell(CelPrincper);
//                        tablePrincper.addCell(CelPrincperr);
//
//                        ///////table 8
//                        PdfPTable tableMtRemboursent = new PdfPTable(4);
//                        tableMtRemboursent.setWidthPercentage(50);
//
//                        PdfPCell  CelMtRemboursent = new PdfPCell(new Phrase("Refund Amount", catFont14Bcour));
//                        CelMtRemboursent.setPadding(12);
//                        CelMtRemboursent.setColspan(2);
//                        CelMtRemboursent.setHorizontalAlignment(Element.ALIGN_RIGHT);
//                        CelMtRemboursent.setVerticalAlignment(Element.ALIGN_RIGHT);
//
//                        PdfPCell CelMtRemboursentt = new PdfPCell(new Phrase( "" +simulation.getMontantRembourse() , subFontPara13N));
//                        CelMtRemboursentt.setPadding(12);
//                        CelMtRemboursentt.setColspan(2);
//                        CelMtRemboursentt.setHorizontalAlignment(Element.ALIGN_RIGHT);
//                        CelMtRemboursentt.setVerticalAlignment(Element.ALIGN_RIGHT);
//
//                        tableMtRemboursent.addCell(CelMtRemboursent);
//                        tableMtRemboursent.addCell(CelMtRemboursentt);
//
//                        ///////table 9
//                        PdfPTable tableInteretTotal = new PdfPTable(4);
//                        tableInteretTotal.setWidthPercentage(50);
//
//                        PdfPCell  CelInteretTotal = new PdfPCell(new Phrase("Total Interest", catFont14Bcour));
//                        CelInteretTotal.setPadding(12);
//                        CelInteretTotal.setColspan(2);
//                        CelInteretTotal.setHorizontalAlignment(Element.ALIGN_RIGHT);
//                        CelInteretTotal.setVerticalAlignment(Element.ALIGN_RIGHT);
//
//                        PdfPCell CelInteretTotall = new PdfPCell(new Phrase( "" +simulation.getInteretTotale() , subFontPara13N));
//                        CelInteretTotall.setPadding(12);
//                        CelInteretTotall.setColspan(2);
//                        CelInteretTotall.setHorizontalAlignment(Element.ALIGN_RIGHT);
//                        CelInteretTotall.setVerticalAlignment(Element.ALIGN_RIGHT);
//
//                        tableInteretTotal.addCell(CelInteretTotal);
//                        tableInteretTotal.addCell(CelInteretTotall);
//
//
//                      //fiin P2
//                        Paragraph finPage2= new Paragraph(" Page 2/2" , smallBold);
//                        finPage2.setAlignment(Element.ALIGN_RIGHT);

                        //	my_pdf_report.add(imgBank);
                        	//my_pdf_report.add(titreBank);
	                      //  my_pdf_report.add(separator1);
	                    //    my_pdf_report.add(titre);
	                        my_pdf_report.add(dateStr);

//	                        my_pdf_report.add(espace);
	                        my_pdf_report.add(espace);
//
	                        my_pdf_report.add(para1);
	                        my_pdf_report.add(para2);
//
//	                        my_pdf_report.add(espace);
	                        my_pdf_report.add(espace);

//	                        my_pdf_report.add(espace);



//	                        my_pdf_report.add(espace);
	                        my_pdf_report.add(titre1);
	                        my_pdf_report.add(espace);

	                        my_pdf_report.add(table);
	  
	                        my_pdf_report.add(espace);
	                        my_pdf_report.add(espace);
	                        my_pdf_report.add(finPage1);
//
//	                        my_pdf_report.add(espace);
//	                        my_pdf_report.add(espace);
//	                        my_pdf_report.add(espace);
//	                        my_pdf_report.add(espace);
//	                        my_pdf_report.add(espace);
////	                        my_pdf_report.add(espace);
//
//	                        my_pdf_report.add(finPage1);
//
//	                        my_pdf_report.newPage();
//
//	                        my_pdf_report.add(titre21);
//	                        my_pdf_report.add(espace);
//	                        my_pdf_report.add(espace);
//	                        my_pdf_report.add(tableLog);//my_pdf_report.add(espace);
//	                        my_pdf_report.add(tabletm);//my_pdf_report.add(espace);
////	                        my_pdf_report.add(tableEch);my_pdf_report.add(espace);
//	                        my_pdf_report.add(tableCap);//my_pdf_report.add(espace);
//	                        my_pdf_report.add(tableMens);//my_pdf_report.add(espace);
//	                        my_pdf_report.add(tableInteret);//my_pdf_report.add(espace);
//	                        my_pdf_report.add(tablePrincper);//my_pdf_report.add(espace);
//	                        my_pdf_report.add(tableMtRemboursent);//my_pdf_report.add(espace);
//	                        my_pdf_report.add(tableInteretTotal);//my_pdf_report.add(espace);
//
//	                        my_pdf_report.add(espace);
//	                        my_pdf_report.add(espace);
//	                        my_pdf_report.add(espace);
//	                        my_pdf_report.add(finPage2);

	                        my_pdf_report.close();
	                        file.close();

	          Runtime.getRuntime()
	                                .exec("rundll32 url.dll,FileProtocolHandler ./src/main/resources/"+ "_"+formater.format(d)+".pdf");
	                       // p.waitFor(2, TimeUnit.SECONDS);



					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				} catch (DocumentException e) {
					e.printStackTrace();
				}

			} catch (MalformedURLException e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return "ESTIMATION_"  + "_"+formater.format(d)+".pdf";
	}

}
