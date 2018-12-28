package com.rajesh.rest.webservices.restfulwebservices.s3;

import java.io.ByteArrayOutputStream;
import java.net.URL;

import org.springframework.web.multipart.MultipartFile;
 
public interface S3Services {
	public ByteArrayOutputStream downloadFile(String keyName);
	public void uploadFile(String keyName, MultipartFile file);
	public URL getDownloadUrl();
}