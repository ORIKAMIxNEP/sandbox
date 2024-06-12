package com.spring_boot_template.application.usecase.project.impl;

import com.spring_boot_template.application.usecase.project.FindTaskByTaskIdUseCase;
import com.spring_boot_template.application.usecase.project.UpdateTaskStatusUseCase;
import com.spring_boot_template.application.usecase.project.converter.UpdateTaskStatusResponseConverter;
import com.spring_boot_template.domain.model.account.Account;
import com.spring_boot_template.domain.model.task.Task;
import com.spring_boot_template.domain.model.task.value.TaskId;
import com.spring_boot_template.presentation.controller.project.request.UpdateTaskStatusRequest;
import com.spring_boot_template.presentation.controller.project.response.UpdateTaskStatusResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateTaskStatusUseCaseImpl implements UpdateTaskStatusUseCase {
    private final FindTaskByTaskIdUseCase findTaskByTaskIdUseCase;
    private final TaskRepository taskRepository;

    @Override
    @Transactional
    public UpdateTaskStatusResponse execute(final UpdateTaskStatusRequest updateTaskStatusRequest) {
        final TaskId taskId = new TaskId(updateTaskStatusRequest.taskId());
        final Task task = findTaskByTaskIdUseCase.execute(taskId);

        // TODO: データベースからUserを取得する
        final Account user = new Account(task.getAssignedUserId(), null, null, null, null);
        // TODO: データベースからUserを取得する

        final Task updatedTask = user.updateTaskStatus(task);

        taskRepository.updateTaskStatus(updatedTask);

        return UpdateTaskStatusResponseConverter.execute(task);
    }
}