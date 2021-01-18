package com.teamroles.app.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.teamroles.app.controller.RoleController;
import com.teamroles.app.model.Membership;
import com.teamroles.app.model.Role;
import com.teamroles.app.repository.RoleRepository;
import com.teamroles.app.service.RoleService;


import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(value = RoleController.class)
public class TeamRolesTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private RoleRepository roleRepository;
	
	@MockBean
	private RoleService roleService;
	
    private UUID tempId =  UUID.randomUUID();

	@Test
	public void testAddRole() throws Exception {
		
        Role devRole = new Role();
        devRole.setName("Developer");
        devRole.setId(tempId);  
    	//String content = "{\"id\":"+"\""+ tempId + "\",\"name\":\"Developer\"}";
    	String url = "/api/addRole";
        
		Mockito.when(roleRepository.save(devRole)).thenReturn(devRole);

		MockHttpServletResponse response = buildRequest(url, devRole);
		String expected = "{id:" + tempId + ",name:Developer}";
		System.out.println(response.getContentAsString());
		JSONAssert.assertEquals(expected, response.getContentAsString(), false);
		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
	
	}

	private MockHttpServletResponse buildRequest(String url, Object object) throws Exception {
		String content = this.toJson(object);
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post(url).
				accept(MediaType.APPLICATION_JSON)
				.content(content)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		return response;
	}
	
	@Test
	public void testAssignRole() throws Exception {
		
		String url = "/api/assignRole";	
		Membership membership = new Membership(tempId, tempId, tempId);
		
		MockHttpServletResponse response = buildRequest(url, membership);
		System.out.println(response.getContentAsString());
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		
	}
	

	@Test
	public void testFetchMemberships() throws Exception {
		
		String url = "/api/fetchMemberships/"+ tempId;		
		mockMvc.perform(get(url)  			
				        .contentType(MediaType.APPLICATION_JSON))
				        .andExpect(status().isOk())
				        .andReturn();  		
		
	}
	
	@Test
	public void testLookupRole() throws Exception {		
		String url = "/api/lookupRole/"+ tempId +"/" + tempId;		
		mockMvc.perform(get(url)  			
				        .contentType(MediaType.APPLICATION_JSON))
				        .andExpect(status().isOk())
				        .andReturn();  		
		
	}
	
	
	
	
	private String toJson(Object object) throws JsonProcessingException {
		
		ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
		return  objectWriter.writeValueAsString(object);
	}
		
}
