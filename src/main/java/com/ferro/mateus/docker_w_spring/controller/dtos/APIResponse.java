package com.ferro.mateus.docker_w_spring.controller.dtos;

import java.util.List;

public record APIResponse<T>(List<T> results, PaginationResponse paging) {
}
