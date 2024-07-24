package com.devkobe.blog.service.dateInfo;

import com.devkobe.blog.domain.dateInfo.DateInfo;
import com.devkobe.blog.repository.dateInfo.DateInfoRepository;
import com.devkobe.blog.web.dto.dateInfo.create.DateInfoCreateRequestDto;
import com.devkobe.blog.web.dto.dateInfo.create.DateInfoCreateResponseDto;
import com.devkobe.blog.web.dto.dateInfo.delete.DateInfoDeleteRequestDto;
import com.devkobe.blog.web.dto.dateInfo.delete.DateInfoDeleteResponseDto;
import com.devkobe.blog.web.dto.dateInfo.read.DateInfoReadRequestDto;
import com.devkobe.blog.web.dto.dateInfo.read.DateInfoReadResponseDto;
import com.devkobe.blog.web.dto.dateInfo.update.DateInfoUpdateRequestDto;
import com.devkobe.blog.web.dto.dateInfo.update.DateInfoUpdateResponseDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DateInfoService {

	private final DateInfoRepository dateInfoRepository;

	// CREATE
	@Transactional
	public DateInfoCreateResponseDto save(DateInfoCreateRequestDto requestDto) {
		DateInfo dateInfo = requestDto.toEntity();
		dateInfoRepository.save(dateInfo);
		return new DateInfoCreateResponseDto(dateInfo);
	}

	// READ
	@Transactional(readOnly = true)
	public List<DateInfoReadResponseDto> findAll() {
		return dateInfoRepository.findAll().stream()
		                         .map(DateInfoReadResponseDto::new)
		                         .collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public DateInfoReadResponseDto findById(DateInfoReadRequestDto requestDto) {
		DateInfo dateInfo = dateInfoRepository.findById(requestDto.getId())
		                         .orElseThrow(() -> new IllegalArgumentException("Invalid dateInfo ID: " + requestDto.getId()));
		return new DateInfoReadResponseDto(dateInfo);
	}

	// UPDATE
	@Transactional
	public DateInfoUpdateResponseDto update(Long id, DateInfoUpdateRequestDto requestDto) {
		DateInfo dateInfo = dateInfoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid dateInfo ID: " + id));

		dateInfo.update(requestDto.getReleaseDate(), requestDto.getModificationDate());

		return new DateInfoUpdateResponseDto(dateInfo);
	}

	// DELETE
	@Transactional
	public DateInfoDeleteResponseDto deleteById(DateInfoDeleteRequestDto requestDto) {
		DateInfo dateInfo = dateInfoRepository.findById(requestDto.getId())
		                                      .orElseThrow(() -> new IllegalArgumentException("Invalid dateInfo ID: " + requestDto.getId()));
		dateInfoRepository.delete(dateInfo);
		return DateInfoDeleteResponseDto.builder().id(requestDto.getId()).build();
	}
}
