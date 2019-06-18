package com.swh.design.template;

import com.swh.design.template.travel.Plain;
import com.swh.design.template.travel.Train;

public class TemplateClient {
    public static void main(String[] args) {
        new Plain().travel();
        System.out.println("-------------------------");
        new Train().travel();
    }
}
