package ru.budnik.university_app1.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.budnik.university_app1.entity.Student;
import ru.budnik.university_app1.util.Util;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/group")
public class GroupController {

    @GetMapping("/showGroup")
    public String showGroup(HttpServletRequest request, Model model){
        String groupName = request.getParameter("groupName");

        //идентификатор удаляемого студента
        String studentIdNeedToBeDelete = request.getParameter("studentId");

        //фамилия и имя добавляемого студента
        String surnameAndName = request.getParameter("newStudentSurnameAndName");

        // если переходим на страницу просмотра группы после нажатия на ссылку удаления студента,
        // то сначала отправляем запрос в базу данных для удаления студента, а потом уже отображаем
        //информацию о студентах группы
        if(studentIdNeedToBeDelete != null){
            Util.deleteStudentFromGroup(studentIdNeedToBeDelete);
        }

        // если переходим на страницу просмотра группы после нажатия на кнопку добавления студента,
        // то сначала отправляем запрос в базу данных для добавления студента, а потом уже отображаем
        //информацию о студентах группы
        if(surnameAndName != null){
            Util.addNewStudent(surnameAndName, groupName);
        }

        //Чтение информации о группе (по ее названию) из базы данных
        List<Student> studentList = Util.getStudentListFromGroup(groupName);
        model.addAttribute("universityGroupName", groupName);
        model.addAttribute("studentList", studentList);
    return "show_group";
    }


}
