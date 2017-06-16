package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoikrugStrategy implements Strategy {
    private static final String URL_FORMAT = "http://moikrug.ru/vacancies?page=%d&q=java+%s";
    String testURL = "http://javarush.ru/testdata/big28data2.html";

    @Override
    public List<Vacancy> getVacancies(String searchString) throws IOException {
        String vacancyQuery = "[class='job']";
        String titleQuery = "[class='title']";
        String compensationQuery = "[class='salary']";
        String addressQuery = "[class='location']";
        String employerQuery = "[class='company_name']";
        List<Vacancy> list = new ArrayList<>();
        int i = 0;
        Vacancy vacancy = new Vacancy();
        try {
            while (true){
                Document document = getDocument(searchString, i);
                Elements vacanciesElements = document.select(vacancyQuery);
                if (!vacanciesElements.isEmpty()){
                    for (Element element: vacanciesElements){
                        vacancy.setTitle(element.select(titleQuery).text());
                        vacancy.setCity(element.select(addressQuery).text());
                        vacancy.setCompanyName(element.select(employerQuery).text());
                        vacancy.setUrl(element.select(titleQuery).attr("href"));
                        vacancy.setSiteName("https://moikrug.ru");
                        if (!element.select(compensationQuery).isEmpty()){
                            vacancy.setSalary(element.select(compensationQuery).text());
                        } else {
                            vacancy.setSalary("");
                        }
                        list.add(vacancy);
                    }
                } else {
                    break;
                }
                i++;
            }
        } catch (Exception error) {
            error.printStackTrace();
        }
        return list;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        return Jsoup.connect(String.format(testURL, page, searchString)).userAgent("Mozilla").referrer("none").get();
    }
}
