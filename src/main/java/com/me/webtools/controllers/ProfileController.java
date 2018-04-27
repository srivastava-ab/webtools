package com.me.webtools.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.me.webtools.pojo.Image;
import com.me.webtools.pojo.User;
import com.me.webtools.service.UserService;

@Controller
public class ProfileController {

	@Autowired
	UserService userService;

	private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);

	@RequestMapping(value = "/profile.htm", method = RequestMethod.GET)
	public String showProfile(HttpServletRequest req, Model model) {

		model.addAttribute("profileEditable", false);
		User user = (User) req.getSession().getAttribute("user");
		String picUrl = "image/" + user.getImageName();
		req.getSession().setAttribute("imageDB", picUrl);

		return "welcome";

	}

	@RequestMapping(value = "/editProfile.htm", method = RequestMethod.GET)
	public String editProfile(Model model, @ModelAttribute("editUser") User user, BindingResult result) {

		model.addAttribute("profileEditable", true);

		return "welcome";

	}

	@RequestMapping(value = "/editUser.htm", method = RequestMethod.POST)
	public ModelAndView addUser(Model model, HttpServletRequest req, HttpServletResponse res,
			@ModelAttribute("user") User user, BindingResult result) throws PersistenceException {
		System.out.println("Hello");

		userService.updateUser(user);

		model.addAttribute("profileEditable", false);

		return new ModelAndView("welcome");
	}
	
	@RequestMapping(value = "/redirectToPassword.htm", method = RequestMethod.GET)
	public ModelAndView redirectPassword( HttpServletRequest req) throws PersistenceException {
		User user1 = (User) req.getSession().getAttribute("user");

		/*System.out.println("Hello");
		String updatedPassword = (String) req.getSession().getAttribute("txtConfirmPassword");
		
		logger.info("updated password is:: "+updatedPassword);
		user.setPassword(updatedPassword);
		userService.updateUser(user);

		model.addAttribute("profileEditable", false);*/

		return new ModelAndView("updatepassword");
	}
	
	
	@RequestMapping(value = "/updatePassword.htm", method = RequestMethod.POST)
	public ModelAndView updatePassword(Model model, HttpServletRequest req, @RequestParam String txtConfirmPassword) throws PersistenceException {
		System.out.println("Hello");
		//String updatedPassword = (String) req.getSession().getAttribute("txtConfirmPassword");
		//String updatedPassword = (String) req.getAttribute("txtConfirmPassword");
		
		User user = (User) req.getSession().getAttribute("user");

		logger.info("updated password is:: "+txtConfirmPassword);
		user.setPassword(txtConfirmPassword);
		userService.updateUser(user);

		model.addAttribute("profileEditable", false);
		model.addAttribute("updated", true);
		return new ModelAndView("updatepassword");
	}
	

	@RequestMapping("/saveImage")
	public String uploadResources(HttpServletRequest servletRequest, @ModelAttribute("abc") Image images, Model model)
			throws IOException {
		model.addAttribute("images", new Image());
		// Get the uploaded files and store them
		List<MultipartFile> files = images.getImages();
		List<String> fileNames = new ArrayList<String>();
		if (null != files && files.size() > 0) {
			User user = (User) servletRequest.getSession().getAttribute("user");
			for (MultipartFile multipartFile : files) {

				String fileName = multipartFile.getOriginalFilename();
				fileNames.add(fileName);
				servletRequest.getSession().setAttribute("image", fileName);

				String filePath = servletRequest.getServletContext().getRealPath("/image");
				File targetFilePath = new File(filePath);
				File targetFile = new File(targetFilePath, fileName);

				String srcFilePath = filePath.replace(
						".metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\WebTools\\image",
						"WebTools\\src\\main\\resources\\images");
				// File dirUpdated = new File(srcFilePath, fileName);
				File srcImageFile = new File(new File(srcFilePath), fileName);

				servletRequest.getSession().setAttribute("imagePath", srcFilePath);
				servletRequest.getSession().setAttribute("fullImagePath", srcImageFile);

				// To set pic upon login

				if (!targetFilePath.exists()) {
					targetFilePath.mkdirs();
				}
				try {
					String picUrl = "image/" + fileName;
					multipartFile.transferTo(srcImageFile);
					FileUtils.copyFile(srcImageFile, targetFile);
					servletRequest.getSession().setAttribute("imageDB", picUrl);
					// uploadToS3(srcImageFile, fileName);

				} catch (IOException e) {
					e.printStackTrace();
				}

				user.setImageName(fileName);
				userService.updateUser(user);

			}
		}

		model.addAttribute("images", images);
		return "welcome";
	}

	@RequestMapping(value = "/deletePic", method = RequestMethod.POST)
	public ModelAndView deletePic(HttpServletRequest req, HttpServletResponse res) throws IOException {

		System.out.println("Inside del pic");
		User user = (User) req.getSession().getAttribute("user");
		user.setImageName("default.png");
		userService.updateUser(user);
		loadBlankPic(req, user);

		return new ModelAndView("welcome");
	}

	private void loadBlankPic(HttpServletRequest req, User user) {
		String finalPicUrl = "image/default.png";
		req.getSession().setAttribute("imageDB", finalPicUrl);

	}

}
