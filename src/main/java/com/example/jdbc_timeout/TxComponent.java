package com.example.jdbc_timeout;

import com.example.jdbc_timeout.mapper.EmpolyeesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class TxComponent {

    private final EmpolyeesMapper empolyeesMapper;

    public void sleep() {
        empolyeesMapper.sleep();
    }

}
