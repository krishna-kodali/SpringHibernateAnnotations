package com.ccs.ems.web;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;

import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ccs.ems.model.Contact;
import com.ccs.ems.model.User;
import com.ccs.ems.svc.ContactService;
import com.ccs.ems.svc.UserService;

@Controller
@RequestMapping("/upload")
public class FileController {
	
	@Autowired
	ContactService contactService;
		
	@RequestMapping(value="uploadForm", method = RequestMethod.GET)
	public String showUploadForm(ModelMap model)
	{
		return "uploadForm";
	}
	
	@RequestMapping(value="uploadFile", method = RequestMethod.POST)
	public String handleFileUpload(@ModelAttribute("contact") Contact contact) {
		
		// gets values of text fields
        String firstName = contact.getFirstName();
        String lastName = contact.getLastName();
        
        InputStream inputStream = null; // input stream of the upload file
        
        contactService.uploadFile(contact);
		return "uploadSuccess";
        
        // obtains the upload file part in this multipart request
        /*byte[] filePart = contact.getPhoto();
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }*/
		
	}
	
	/*@RequestMapping(value="uploadFile", method=RequestMethod.POST)
    public @ResponseBody String handleFileUpload( 
            @RequestParam("file") MultipartFile file){
            String name = "test11";
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream = 
                        new BufferedOutputStream(new FileOutputStream(new File(name + "-uploaded")));
                stream.write(bytes);
                stream.close();
                return "You successfully uploaded " + name + " into " + name + "-uploaded !";
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name + " because the file was empty.";
        }
    }*/
}
