package come.test.hplus.controllers;


import come.test.hplus.beans.Product;
import come.test.hplus.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {


    @Autowired
    private ProductRepository productRepository;


    @GetMapping("/search")
    public String search(@RequestParam("search") String search, Model model) {
        System.out.println("in search controller");
        System.out.println("search criteria : " + search);

        List<Product> products = new ArrayList<>();
        products = productRepository.searchByName(search);
        model.addAttribute("products", products);

        return "search";


    }

//    @GetMapping
//    public ModelAndView search(){
//        System.out.println("in search controller");
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("search");
//        return modelAndView;
//    }


}
