package com.leadtech.SmartStylist.controller;

import com.leadtech.SmartStylist.service.ExportService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequestMapping("/export")
public class ExportController {

    @Autowired
    private ExportService exportService;

    @GetMapping
    public String viewExportPage(Model model) {
        return "exports/export-data";
    }

    @GetMapping(value = "/clients/csv", produces = "text/csv")
    @ResponseBody
    public void exportClientsAsCsv(HttpServletResponse response) throws IOException {
        response.setHeader("Content-Disposition", "attachment; filename=clients.csv");
        exportService.exportClients(response.getOutputStream(), "csv");
    }

    @GetMapping(value = "/clients/json", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void exportClientsAsJson(HttpServletResponse response) throws IOException {
        response.setHeader("Content-Disposition", "attachment; filename=clients.json");
        exportService.exportClients(response.getOutputStream(), "json");
    }

    // Métodos para exportar produtos
    @GetMapping(value = "/products/csv", produces = "text/csv")
    @ResponseBody
    public void exportProductsAsCsv(HttpServletResponse response) throws IOException {
        response.setHeader("Content-Disposition", "attachment; filename=products.csv");
        exportService.exportProducts(response.getOutputStream(), "csv");
    }

    @GetMapping(value = "/products/json", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void exportProductsAsJson(HttpServletResponse response) throws IOException {
        response.setHeader("Content-Disposition", "attachment; filename=products.json");
        exportService.exportProducts(response.getOutputStream(), "json");
    }

    @GetMapping(value = "/fashionTrends/csv", produces = "text/csv")
    @ResponseBody
    public void exportFashionTrendsAsCsv(HttpServletResponse response) throws IOException {
        response.setHeader("Content-Disposition", "attachment; filename=fashion-trends.csv");
        exportService.exportFashionTrends(response.getOutputStream(), "csv");
    }

    @GetMapping(value = "/fashionTrends/json", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void exportFashionTrendsAsJson(HttpServletResponse response) throws IOException {
        response.setHeader("Content-Disposition", "attachment; filename=fashion-trends.json");
        exportService.exportFashionTrends(response.getOutputStream(), "json");
    }

    @GetMapping(value = "/lookbooks/csv", produces = "text/csv")
    @ResponseBody
    public void exportLookbooksAsCsv(HttpServletResponse response) throws IOException {
        response.setHeader("Content-Disposition", "attachment; filename=lookbooks.csv");
        exportService.exportLookbook(response.getOutputStream(), "csv");
    }

    @GetMapping(value = "/lookbooks/json", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void exportLookbooksAsJson(HttpServletResponse response) throws IOException {
        response.setHeader("Content-Disposition", "attachment; filename=lookbooks.json");
        exportService.exportLookbook(response.getOutputStream(), "json");
    }

    @GetMapping(value = "/purchaseHistory/csv", produces = "text/csv")
    @ResponseBody
    public void exportPurchaseHistoryAsCsv(HttpServletResponse response) throws IOException {
        response.setHeader("Content-Disposition", "attachment; filename=purchase-history.csv");
        exportService.exportPurchaseHistory(response.getOutputStream(), "csv");
    }

    @GetMapping(value = "/purchaseHistory/json", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void exportPurchaseHistoryAsJson(HttpServletResponse response) throws IOException {
        response.setHeader("Content-Disposition", "attachment; filename=purchase-history.json");
        exportService.exportPurchaseHistory(response.getOutputStream(), "json");
    }

}
