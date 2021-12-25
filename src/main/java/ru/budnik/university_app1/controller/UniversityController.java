package ru.budnik.university_app1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.budnik.university_app1.entity.Group;
import ru.budnik.university_app1.util.Util;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/university")
public class UniversityController {

    @GetMapping("/showGroups")
    public String showGroups(HttpServletRequest request, Model model){
        // если мы перешли в метод отображения всех групп, после того, как была добавлена новая группа
        // то сохраним ее в БД и после этого отобразми список всех групп университета
        String groupName = request.getParameter("newGroupName");
        if (groupName != null){
            Util.addNewGroup(groupName);
        }

        List<Group> groupList = Util.getAllGroups();
        model.addAttribute("allGroups", groupList);
        return "show_all_groups";
    }

}
