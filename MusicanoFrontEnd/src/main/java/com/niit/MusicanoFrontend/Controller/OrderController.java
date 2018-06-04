package com.niit.MusicanoFrontend.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.MusicanoBackEnd.dao.BillingDao;
import com.niit.MusicanoBackEnd.dao.CartDao;
import com.niit.MusicanoBackEnd.dao.CartItemsDao;
import com.niit.MusicanoBackEnd.dao.OrderDao;
import com.niit.MusicanoBackEnd.dao.OrderItemsDao;
import com.niit.MusicanoBackEnd.dao.PayDao;
import com.niit.MusicanoBackEnd.dao.ProductDao;
import com.niit.MusicanoBackEnd.dao.ShippingDao;
import com.niit.MusicanoBackEnd.dao.UserDao;
import com.niit.MusicanoBackEnd.model.Billing;
import com.niit.MusicanoBackEnd.model.Cart;
import com.niit.MusicanoBackEnd.model.CartItems;
import com.niit.MusicanoBackEnd.model.Order;
import com.niit.MusicanoBackEnd.model.OrderItems;
import com.niit.MusicanoBackEnd.model.Pay;
import com.niit.MusicanoBackEnd.model.Product;
import com.niit.MusicanoBackEnd.model.Shipping;
import com.niit.MusicanoBackEnd.model.User;
import com.niit.MusicanoFrontend.OtpGenerator.OtpGenerator;

@Controller
public class OrderController {
	@Autowired
	Cart cart;
	@Autowired
	CartDao cartDao;
	@Autowired
	CartItems cartItems;
	@Autowired
	CartItemsDao cartItemDao;
	//@Autowired
	//Card card;
	@Autowired
	Billing billing;
	@Autowired
	BillingDao billingDao;
	@Autowired
	Shipping shipping;
	@Autowired
	ShippingDao shippingDao;
	@Autowired
	Pay pay;
	@Autowired
	PayDao payDao;
	@Autowired
	Order order;
	@Autowired
	OrderDao orderDao;
	@Autowired
	OrderItems orderItem;
	@Autowired
	OrderItemsDao orderItemDao;
	@Autowired
	Product product;
	@Autowired
	ProductDao productDao;
	@Autowired
	User user;
	@Autowired
	UserDao userDao;
	@Autowired
	List<CartItems> cartItem1;
	
	@Autowired
	private JavaMailSender mailSender;
	
	String o;
	
	@RequestMapping("/Buyall")
	public String orderall(Model model,HttpSession session)
	{
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		if(!(authentication instanceof AnonymousAuthenticationToken))
		{
			String currusername=authentication.getName();
			user=userDao.getEmail(currusername);
			cart=user.getCart();
			product=null;
			session.setAttribute("products", product);
//			cartItems=cartItemDao.getCartItems(cart.getCart_Id());
			cartItem1=cartItemDao.getlist(cart.getCart_Id());
			if(cartItem1==null||cartItem1.isEmpty())
			{
				return "redirect:/checkout";
			}
			else
			{
				billing=billingDao.getBilling(user.getUserId());
				List<Shipping> shippings=shippingDao.getaddbyuser(user.getUserId());
				model.addAttribute("billing",billing);
				model.addAttribute("user",user);
				model.addAttribute("shippingaddr",shippings);
				model.addAttribute("shipping", new Shipping());
				model.addAttribute("p",product);
				session.setAttribute("p", product);
				
			}
		}
		return "billing";
	}
	
	 
	 @RequestMapping("/Buy/{proId}/{cartItems_Id}")
	 public String order(@PathVariable("proId")String id,@PathVariable("cartItems_Id")String id2,Model model,HttpSession session)
	 {
		 Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		 if(!(authentication instanceof AnonymousAuthenticationToken))
		 {
			 String currusername=authentication.getName();
			 user=userDao.getEmail(currusername);
			 cart=user.getCart();
			 cartItem1=null;
			 product=productDao.getProduct(id);
			 billing=billingDao.getBilling(user.getUserId());
			 cartItems=cartItemDao.getCartItems(id2);
			 //System.out.println(billing.getCountry());
			 //for(Billing b:billing)
			 //{
				// System.out.println(b.getbId());
				 //System.out.prinltn(b.getCountry());
			 //}
			 List<Shipping> shippings=shippingDao.getaddbyuser(user.getUserId());
				user.setBilling(billing);
				model.addAttribute("billing",billing);
				model.addAttribute("user",user);
				model.addAttribute("shippingaddr",shippings);
				model.addAttribute("shipping",new Shipping());
				session.setAttribute("p",product);
				
				model.addAttribute("CartItems", cartItems);
				
				return "billing";
		 }
		 else
		 {
			 return "redirect:/";
		 }
	 }
	 @RequestMapping("/orderConfirm")
	 public String payment(@ModelAttribute("shipping")Shipping sh,Model model)
		{
			//if(cartItem==null || cartItem.isEmpty())
			//{
				//System.out.println("sorry");
			//}
		    sh.setUser(user);
			shipping=sh;
			model.addAttribute("billing",billing);
			model.addAttribute("shipping",shipping);
			model.addAttribute("p",product);
			model.addAttribute("CartItem1",cartItem1);
			model.addAttribute("Cart",cart);
			model.addAttribute("Grandtotal", cart.getGrandtotal());
			return "orderConfirm";
		}
	 @RequestMapping("/previous")
	 public String previous(Model model)
	 {
		 List<Shipping> shippings=shippingDao.getaddbyuser(user.getUserId());
			model.addAttribute("shippingaddr",shippings);
			model.addAttribute("billing",billing);
			model.addAttribute("shipping", shipping);
			model.addAttribute("Product",product);
			return "billship";
	 }
	 @RequestMapping("/pay")
	 public String pay(Model model)
	 {
         //List<Card> cards=cardDao.getcardbyuser(userInfo.getuId());
         //model.addAttribute("cards",cards);
         //model.addAttribute("card",new Card());
			
			return "Payment";
	 }
	 @RequestMapping("/payment")
	 public String payment(@RequestParam("otp")String otp,Model model)
	 {
		 int a;
		 if(otp==null)
			 a=2;
		 else
			 a=1;
		 switch(a)
		 {
		 case 1:
			 if(otp.equals(o))
			 {
				 pay.setPaymentMethod("COD");
				 pay.setPaymentStatus("NO");
				 break;
			 }
			 else
			 {
				 return "redirect:/pay";
			 }
		 case 2:
			 pay.setPaymentMethod("Card");
			 pay.setPaymentStatus("yes");
			 payDao.saveorupdatePay(pay);
//             //cardDao.saveorupdate(car);
			 break;
		 }
		 return "redirect:/orderconfirmation";
	 }
//      @RequestMapping("/payment")
//		public String payment(@RequestParam("payb2") String str,Model model)
//		{
//			System.out.println(1324);
//			int a;
//			System.out.println(str);
//			if(str.equals(o))
//			{
//				return "redirect:/thankyou";
//			}
//			
//			return "redirect:/orderconfirmation";
//			
//			
//		}
		@RequestMapping("/orderconfirmation")
		public String orderconfirmation(HttpSession session)
		{
//			System.out.println(32);
			order.setBilling(billing);
			order.setShipping(shipping);
//			order.setPay(pay);
			order.setUser(user);
//			System.out.println(524);
			if(cartItem1 == null)
			{
				order.setGrandtotal(product.getPrice());
				orderDao.saveorupdateOrd(order);
				orderItem.setOrder(order);
				orderItem.setProId(product.getProId());
				orderItemDao.saveorupdateOrditem(orderItem);
				System.out.println(cartItems.getPrice());
				cart.setGrandtotal(cart.getGrandtotal() - cartItems.getPrice());
				cart.setTotalItems(cart.getTotalItems()-1);
				session.setAttribute("items", cart.getTotalItems());
				cartDao.saveorupdateCart(cart);
				cartItemDao.deleteCartItems(cartItems);
				product.setQty(product.getQty()-1);
				System.out.println("sadgds");
				productDao.saveorupdatePro(product);
				//cartItemDao.delete(cartItemDao.getlistall(cart.getCart_id(),productInfo.getPrdid()));
				System.out.println(324);
			}
			else
			{
				System.out.println(656);
				order.setGrandtotal(cart.getGrandtotal());
				orderDao.saveorupdateOrd(order);
				int count=0;
				for(CartItems c: cartItem1)
				{
					System.out.println(3444);
					orderItem.setOrder(order);
					//orderItem.setProductid(c.getProductInfo().getPrdid());
					System.out.println(3443);
					orderItemDao.saveorupdateOrditem(orderItem);
					cartItemDao.deleteCartItems(c);
//					product.setQuantity(quantity);=product.getQuantity()-1;
				}
//				product.setQuantity(product.getQuantity()-count);
//				System.out.println("sadgds");
//				productDao.saveorupdate(product);
				cart.setGrandtotal(0.0);
				cart.setTotalItems(0);
				System.out.println(346);
				session.setAttribute("items", cart.getTotalItems());
				cartDao.saveorupdateCart(cart);				
			}
			cartItems=null;
			cartItem1=null;
			product=null;
			order=new Order();
			orderItem= new OrderItems();
			System.out.println(565);
			return "Thankyou";
			
		}
		@RequestMapping(value="/SendMail")
		public void SendMail() 
		{
//			System.out.println(21312);
			Authentication authentication =	SecurityContextHolder.getContext().getAuthentication();
			if (!(authentication instanceof AnonymousAuthenticationToken)) {
				String currusername = authentication.getName();
				user = userDao.getEmail(currusername);
				OtpGenerator ot=new OtpGenerator();
//				String o=ot.Otpga();
				o=ot.Otpga();
				String recipientAddress = user.getEmail_Id();
				String subject="OTP";
				//String subject = request.getParameter("subject");
				String message = "your one time password is "+o+" ";
//
//				// prints debug info
//				System.out.println("To:" + recipientAddress);
				System.out.println("Subject: " + subject);
				System.out.println("Message: " + message);

//				System.out.println("OTP:"+ otp);
//				 creates a simple e-mail object
				SimpleMailMessage email = new SimpleMailMessage();
				email.setTo(recipientAddress);
				email.setSubject(subject);	
				email.setText(message);
				//email.setSubject(otp);
//				// sends the e-mail
				mailSender.send(email);
			}
		}
				// forwards to the view named "Result"
				//return "Result";

}
