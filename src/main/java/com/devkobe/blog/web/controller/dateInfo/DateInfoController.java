package com.devkobe.blog.web.controller.dateInfo;

import com.devkobe.blog.domain.dateInfo.DateInfo;
import com.devkobe.blog.service.dateInfo.DateInfoService;
import com.devkobe.blog.web.dto.dateInfo.DateInfoResponseDto;
import com.devkobe.blog.web.dto.dateInfo.create.DateInfoCreateRequestDto;
import com.devkobe.blog.web.dto.dateInfo.create.DateInfoCreateResponseDto;
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
@RequestMapping("/api/dateInfo")
public class DateInfoController {

	private final DateInfoService dateInfoService;

	// CREATE
	@PostMapping
	public DateInfoCreateResponseDto save(@RequestBody DateInfoCreateRequestDto requestDto) {
		DateInfo dateInfo = requestDto.toEntity();
		Long id = dateInfoService.save(dateInfo);
		DateInfo savedDateInfo = dateInfoService.findById(id);
		return new DateInfoCreateResponseDto(savedDateInfo);
	}

	// READ
	@GetMapping
	public List<DateInfoResponseDto> findAll() {
		return dateInfoService.findAll();
	}

	@GetMapping("/{id}")
	public DateInfoResponseDto findById(@PathVariable Long id) {
		return dateInfoService.findById(id);
	}

	// UPDATE
	@PutMapping("/{id}")
	public Long update(@PathVariable Long id, @RequestBody DateInfo updatedDateInfo) {
		return dateInfoService.update(id, updatedDateInfo);
	}

	// DELETE
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		dateInfoService.deleteById(id);
	}
}
