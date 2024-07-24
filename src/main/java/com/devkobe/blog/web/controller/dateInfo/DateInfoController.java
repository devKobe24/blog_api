package com.devkobe.blog.web.controller.dateInfo;

import com.devkobe.blog.service.dateInfo.DateInfoService;
import com.devkobe.blog.web.dto.dateInfo.create.DateInfoCreateRequestDto;
import com.devkobe.blog.web.dto.dateInfo.create.DateInfoCreateResponseDto;
import com.devkobe.blog.web.dto.dateInfo.delete.DateInfoDeleteRequestDto;
import com.devkobe.blog.web.dto.dateInfo.delete.DateInfoDeleteResponseDto;
import com.devkobe.blog.web.dto.dateInfo.read.DateInfoReadRequestDto;
import com.devkobe.blog.web.dto.dateInfo.read.DateInfoReadResponseDto;
import com.devkobe.blog.web.dto.dateInfo.update.DateInfoUpdateRequestDto;
import com.devkobe.blog.web.dto.dateInfo.update.DateInfoUpdateResponseDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/dateInfo")
public class DateInfoController {

	private final DateInfoService dateInfoService;

	// CREATE
	@PostMapping
	public DateInfoCreateResponseDto save(@RequestBody DateInfoCreateRequestDto requestDto) {
		return dateInfoService.save(requestDto);
	}

	// READ
	@GetMapping
	public List<DateInfoReadResponseDto> findAll() {
		return dateInfoService.findAll();
	}

	@GetMapping("/{id}")
	public DateInfoReadResponseDto findById(@PathVariable Long id) {
		DateInfoReadRequestDto requestDto = new DateInfoReadRequestDto();
		requestDto.setId(id);
		return dateInfoService.findById(requestDto);
	}

	// UPDATE
	@PutMapping("/{id}")
	public DateInfoUpdateResponseDto update(@PathVariable Long id, @RequestBody DateInfoUpdateRequestDto updatedDateInfo) {
		return dateInfoService.update(id, updatedDateInfo);
	}

	// DELETE
	@DeleteMapping("/{id}")
	public DateInfoDeleteResponseDto deleteById(@PathVariable Long id) {
		DateInfoDeleteRequestDto requestDto = DateInfoDeleteRequestDto.builder().
		                                                              id(id)
		                                                              .build();
		return dateInfoService.deleteById(requestDto);
	}
}
