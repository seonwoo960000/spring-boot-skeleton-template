package com.example.personalprojecttemplate.domain.story;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.personalprojecttemplate.domain.story.Story;

public interface StoryRepository extends JpaRepository<Story, Long> {
}