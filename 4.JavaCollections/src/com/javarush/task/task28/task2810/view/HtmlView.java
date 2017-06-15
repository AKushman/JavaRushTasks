package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class HtmlView implements View {

    Controller controller;
    private final String filePath = "./src/" + this.getClass().getPackage().toString().replaceAll("package ", "").replaceAll("\\.", "/") + "/vacancies.html";

    @Override
    public void update(List<Vacancy> vacancies) {
       updateFile(getUpdatedFileContent(vacancies));
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod() {
        try {
            controller.onCitySelect("odessa");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getUpdatedFileContent(List<Vacancy> list) {
        Document document = null;
        try {
            document = getDocument();
            Element element = document.getElementsByClass("template").first();
            Element pattern = element.clone();
            pattern.removeClass("template");
            pattern.removeAttr("style");
            document.getElementsByAttributeValue("class", "vacancy").remove();
            for (Vacancy v : list) {
                Element div = pattern.clone();
                div.getElementsByClass("city").first().text(v.getCity());
                div.getElementsByClass("companyName").first().text(v.getCompanyName());
                div.getElementsByClass("salary").first().text(v.getSalary());
                Element a = div.getElementsByTag("a").first();
                a.text(v.getTitle());
                a.attr("href", v.getUrl());
                element.before(div.outerHtml());
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
            return "Some exception occurred";
        }
        return document.outerHtml();
    }

    private void updateFile(String body) {
        try (FileOutputStream out = new FileOutputStream(filePath)) {
            out.write(body.getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    protected Document getDocument() throws IOException {
        return Jsoup.parse(new File(filePath), "UTF-8");
    }

}
