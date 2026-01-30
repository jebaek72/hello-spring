package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!!!!!");
        // return "hello"; : hello.html을 실행시켜라
        return "hello";
    }

//    기본적인 MVC 패턴 구조
//    컨트롤러 : 비즈니스 로직 / 뷰 : 화면 그리기 / 모델 : 데이터
//    http://localhost:8080/hello-mvc?name=spring!!!!! 입력하면 해당 name 파라미터 값으로 치환
//    서버에서 html로 완성한 다음(랜더링한 다음) 클라이언트에 보내줌
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

//    api 방식 기본
    @GetMapping("hello-string")
//    @ResponseBody : HTTP 응답 body에 이 내용을 넣어주겠다.
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello" + name; // "hello spring" 문자
    }

//    api 데이터 방식
//    http://localhost:8080/hello-api?name=string : json 방식으로 데이터 전달
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // 객체로 반환(json)
    }
//    Hello class 생성
    static class Hello {
        private String name;

        // name은 private이니, 메서드로 접근하도록 하기
        public String getName(){
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }



}
