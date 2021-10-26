package net.parwand.springmvc.service;

import net.parwand.springmvc.entity.Drink;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class BAKService {
    Map<String, Double> drinksMap = Map.ofEntries(
            Map.entry("bier", 0.05),
            Map.entry("wein", 0.12),
            Map.entry("korn", 0.32),
            Map.entry("vodka", 0.40),
            Map.entry("whiskey", 0.43)
    );
    double w = 0.0;

    public double berechnen(String geschelcht, double gewicht, List<Double> getraenkemengen){
        List<Drink> drinks = getDrinks(getraenkemengen);
        double a;
        double m = gewicht;
        double r;
        double p = 0.8;
        if(geschelcht.equals("Mann")){
            r = 0.7;
        }else {
            r = 0.6;
        }
        resetResult();
        for (Drink drink:drinks){
            a =drink.menge() *  drinksMap.get(drink.type()) * p;
            w += a/(m*r);
        }

        return Math.round(w*100.0)/100.0;
    }

    private List<Drink> getDrinks(List<Double> getraenkemengen) {
        List<Drink> drinks = new LinkedList<>();
        drinks.add(new Drink("bier", getraenkemengen.get(0)));
        drinks.add(new Drink("wein", getraenkemengen.get(1)));
        drinks.add(new Drink("korn", getraenkemengen.get(2)));
        drinks.add(new Drink("vodka", getraenkemengen.get(3)));
        drinks.add(new Drink("whiskey", getraenkemengen.get(4)));
        return drinks;
    }

    public void resetResult(){
        w = 0.0;
    }
}
