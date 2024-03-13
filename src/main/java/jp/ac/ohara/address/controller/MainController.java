package jp.ac.ohara.address.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jp.ac.ohara.address.model.AddressBook;
import jp.ac.ohara.address.service.AddressBookService;

@Controller
public class MainController {

    private final AddressBookService addressBookService;

    public MainController(AddressBookService addressBookService) {
        this.addressBookService = addressBookService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "こんにちは");
        return "top";
    }

    @GetMapping("/view")
    public String index1(Model model) {
        model.addAttribute("AddressList", addressBookService.getAddressList());
        return "view";
    }
    @GetMapping("/view/form")
    public String showRegisterForm(Model model) {
        // 新しいAddressBookオブジェクトを作成し、フォームにバインドする
        model.addAttribute("addressBook", new AddressBook());
        return "form"; // フォームのビューを返す
    }
 
    @PostMapping("/view/form")
    public String registerAddressBook(@ModelAttribute AddressBook addressBook) {
        // フォームから送信されたデータを処理する
        addressBookService.save(addressBook);
        return "redirect:/view"; // アドレス帳一覧ページにリダイレクト
    }
    
    
}
