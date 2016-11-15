package javarush.test.controller;

import javarush.test.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserDao userDao;

    @RequestMapping("/")
    public String hello(Model model,
                        @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                        @RequestParam(value = "searchText", required = false) String searchText){
        if (pageNumber == null) {
            pageNumber = 0;
        }
        int pageCount =  userDao.getUserPagesCount();
        model.addAttribute("countOFPages", pageCount);
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("users", userDao.getUsersOnPage(pageNumber));
        model.addAttribute("pagination", createPagination(pageNumber, pageCount));
        model.addAttribute("searchText", searchText);
        return "index";
    }

    @RequestMapping("/add")
    public String addUser(Model model){
        return "user_add";
    }

    @RequestMapping("/remove")
    public String removeUser(Model model, @RequestParam(value = "id") Integer userId){
        userDao.delete(userDao.getById(userId));
        return "redirect:/";
    }

    public List<Integer> createPagination(int pageIndex, int pagesCount){
        List<Integer> pageIndexes = new ArrayList<>();
        int leftIndex = pageIndex - 5 >= 0 ? pageIndex - 5 : 0;
        int rightIndex = pageIndex + 5 <= pagesCount ? pageIndex + 5 : pagesCount;
        if(pageIndex - leftIndex < 5){
            rightIndex += 5 - (pageIndex - leftIndex);
            rightIndex = rightIndex <= pagesCount ? rightIndex : pagesCount;
        }
        if(rightIndex - pageIndex < 5){
            leftIndex -= 5 - (rightIndex - pageIndex);
            leftIndex = leftIndex >= 0 ? leftIndex : 0;
        }
        for (int i = leftIndex; i <= rightIndex ; i++) {
            pageIndexes.add(i);
        }
        return pageIndexes;
    }
}
