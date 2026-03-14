package com.pos.retail_billing.utils;

import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import com.pos.retail_billing.model.CartItem;
import com.pos.retail_billing.model.Order;

public class PdfGenerator {

    public static void generateInvoice(Order order) {

        try {

            Document document = new Document();

            String fileName = "invoice_" + order.getId() + ".pdf";

            PdfWriter.getInstance(document, new FileOutputStream("invoices/" + fileName));

            document.open();

            document.add(new Paragraph("Retail POS Invoice"));
            document.add(new Paragraph("Order ID: " + order.getId()));
            document.add(new Paragraph("Customer ID: " + order.getCustomerId()));
            document.add(new Paragraph("Customer Name: " + order.getCustomerName()));
            document.add(new Paragraph(" "));

            PdfPTable table = new PdfPTable(4);

            table.addCell("Product");
            table.addCell("Price");
            table.addCell("Quantity");
            table.addCell("Total");

            List<CartItem> items = order.getItems();

            for (CartItem item : items) {

                table.addCell(item.getName());
                table.addCell(String.valueOf(item.getPrice()));
                table.addCell(String.valueOf(item.getQuantity()));
                table.addCell(String.valueOf(item.getPrice() * item.getQuantity()));
            }

            document.add(table);

            document.add(new Paragraph(" "));
            document.add(new Paragraph("Subtotal: " + order.getSubtotal()));
            document.add(new Paragraph("Tax: " + order.getTax()));
            document.add(new Paragraph("Total: " + order.getTotal()));

            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}