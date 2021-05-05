package com.ssafy.boot.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.boot.model.dto.Product;
import com.ssafy.boot.model.service.ProductService;


@RestController
@CrossOrigin("*")
public class ProductController {
	
	@Autowired
	private ProductService pservice;
	
	@GetMapping("/productMain")
	public ResponseEntity<List<Product>> main() throws SQLException{
		List<Product> result = pservice.selectAll();
		
		if(result==null||result.size()==0) {
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Product>>(result, HttpStatus.OK);
	}
	

	
//	@GetMapping("/registForm")
//	public String getRegistationForm(HttpSession session) {
//		return "regist";
//	}
//	
//	@PostMapping("/product")
//	public ModelAndView addProduct(Boolean check, Product product) {
//		ModelAndView mav = new ModelAndView();
//		if (!check) {
//			mav.setViewName("regist");
//			mav.addObject("msg","중복된 코드를 가진 상품이 존재합니다.");
//		} else {
//			try {
//				pservice.insert(product);
//				mav.addObject("msg", "상품 등록에 성공하였습니다.");
//				mav.setViewName("regist");
//			} catch (NoSuchFieldException | SQLException e) {
//				e.printStackTrace();
//				mav.setViewName("error/500");
//			}			
//		}
//		
//		return mav;
//	}
	
	@PostMapping("/product")
	public ResponseEntity<String> add(@RequestBody Product product) throws SQLException{
		boolean result = pservice.insert(product);
		if(result)
			return new ResponseEntity<String>("success",HttpStatus.OK);
		return new ResponseEntity<String>("fail",HttpStatus.BAD_REQUEST);
		
	}
	

	
//////////////////////////////////////////////////////////////////////	
//	@GetMapping("/pcodeCheck")
//	@ResponseBody // jsp 찾지않고 다이렉트로 응답함
//	public String pcodeCheck(String pCode) throws SQLException { //화면을 만들어주는게 목적이 아님. 지금 보낸 상품코드가 써도 된다 안된다만 알려주면 됨.
//		if(pservice.select(pCode)!=null) {
//			return "no"; // no.jsp 아님 주의!!
//		}else {
////		이전 Servlet 작성에는 이렇게 해야함. resp.getWriter().print("yes");
//			return "yes"; // yes.jsp 아님 주의!!
//		}
//		
//	}
}

























