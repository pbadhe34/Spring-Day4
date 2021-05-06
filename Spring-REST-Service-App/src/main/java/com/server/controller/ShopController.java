package com.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.server.model.Shop;
import com.server.model.User;
 

@Controller
@RequestMapping("/app/brands")
public class ShopController {

	@RequestMapping(value = "{name}", method = RequestMethod.GET)
	public @ResponseBody
	Shop getShopData(@PathVariable String name) {

		Shop shop = new Shop();
		shop.setName(name);
		shop.setStaffName(new String[] { "data1", "aser1" });

		return shop;

	}
	@RequestMapping(value = "/user/{uname}", method = RequestMethod.GET)
	public @ResponseBody
	User getUserData(@PathVariable String uname) {

		 User obj = new User();
		 obj.setName(uname);
		 obj.setNum(uname.length());
		 obj.setIncome(78965.00);

		return obj;

	}

}