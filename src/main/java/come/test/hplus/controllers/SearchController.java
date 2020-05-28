package come.test.hplus.controllers;


import come.test.hplus.beans.Product;
import come.test.hplus.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@Controller
public class SearchController {


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AsyncTaskExecutor executor;

    @GetMapping("/search")
    public DeferredResult<String> search(@RequestParam("search") String search, Model model, HttpServletRequest request) {
        DeferredResult deferredResult = new DeferredResult();

        System.out.println("in search controller");
        System.out.println("search criteria : " + search);
        System.out.println("Async supported in application: "+request.isAsyncSupported());
        System.out.println("Thread from the servlet container : " + Thread.currentThread().getName());

       /*return () -> {
            Thread.sleep(3000);
            System.out.println("Thread from the spring mvc task executor : " + Thread.currentThread().getName());
            List<Product> products = new ArrayList<>();
            products = productRepository.searchByName(search);
            model.addAttribute("products", products);

            return "search";

        };*/

        executor.execute(()->{
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread from the spring mvc task executor : " + Thread.currentThread().getName());
            List<Product> products = new ArrayList<>();
            products = productRepository.searchByName(search);
            model.addAttribute("products", products);
            deferredResult.setResult("search");
        });
        return deferredResult;
    }

//    @GetMapping
//    public ModelAndView search(){
//        System.out.println("in search controller");
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("search");
//        return modelAndView;
//    }


}
