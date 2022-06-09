package com.example.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.controller.form.LoginForm;
import com.example.controller.form.RankingForm;
import com.example.entity.Login;
import com.example.entity.Ranking;
import com.example.service.LoginService;
import com.example.service.RankingService;

/**
 * コントローラ
 */
@Controller
public class RankingController {

	/**
	 * メッセージリソース用
	 */
	@Autowired
	MessageSource messageSource;

	@Autowired
	RankingService rankingService;

	@Autowired
	LoginService loginService;

	/**
	 * トップ画面表示
	 */
	@RequestMapping("/login")
	public String index(@ModelAttribute("login") LoginForm form, Model model) {
		return "login";
	}
	@RequestMapping(value = "/execute", params = "login", method = RequestMethod.POST)
	public String search(@Validated @ModelAttribute("login") LoginForm form, BindingResult bindingResult,@ModelAttribute("ranking") RankingForm form2,Model model) {
		if (bindingResult.hasErrors()) {
			return "login";
		}

		Login list = loginService.findIdAndPass(form.getLogin_id(),form.getPassword(),form.getName());

		if (list == null) {
			// メッセージリソースファイルから、メッセージを取得
			String errMsg = messageSource.getMessage("select.error", null, Locale.getDefault());
			model.addAttribute("msg", errMsg);

			return "login";
		} else {
			
			String name = list.getName();
			model.addAttribute("name",name);
			
			return "top";
		}
	}

	/**
	 * 検索結果画面遷移
	 */
	@RequestMapping(value = "/execute", params = "search", method = RequestMethod.POST)
	public String search(@ModelAttribute("ranking") RankingForm form,Model model) {

		Ranking ranking = new Ranking(form.getId(), form.getName(), form.getScore());
		List<Ranking> list = rankingService.findAll(ranking);
		if (list.isEmpty()) {
			// メッセージリソースファイルから、メッセージを取得
			String errMsg = messageSource.getMessage("select.error", null, Locale.getDefault());
			model.addAttribute("msg", errMsg);

			return "top";
		} else {
			model.addAttribute("rankingList", list);

			return "searchResult";
		}
	}

	/**
	 * 登録完了画面遷移
	 */
	@RequestMapping(value = "/execute", params = "insert", method = RequestMethod.POST)
	public String insert(@Validated @ModelAttribute("ranking") RankingForm form, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			return "top";
		}

		Ranking ranking = new Ranking(form.getId(), form.getName(), form.getScore());

		rankingService.insert(ranking);
		
		return "insertResult";
	}

	@RequestMapping(value = "/execute", params = "deleteResult", method = RequestMethod.POST)
	public String deleteResult(@ModelAttribute("ranking") RankingForm form,Model model) {

		Ranking ranking = new Ranking(form.getId(), form.getName(), form.getScore());

		rankingService.delete(ranking);

		return "deleteResult";
	}

	@RequestMapping(value = "/execute",params = "play",method = RequestMethod.POST )
	public String play(@ModelAttribute("ranking") RankingForm form, Model model) {

		return "play";
	}

	@RequestMapping(value = "/top")
	public String top(@ModelAttribute("ranking") RankingForm form, Model model) {

		return "top";
	}

	@RequestMapping(value = "/delete")
	public String delete(@ModelAttribute("ranking") RankingForm form,Model model) {

		return "delete";
	}
}

