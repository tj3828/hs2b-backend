package com.hs2b.web.controller;

import com.hs2b.backend.web.controller.EnvController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.mock.env.MockEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

class EnvControllerUnitTest {

    @Test
    public void real_profile이_조회된다() {
        String expectedProfile = "real";
        MockEnvironment mockEnvironment = new MockEnvironment();
        mockEnvironment.addActiveProfile(expectedProfile);
        mockEnvironment.addActiveProfile("real-db");

        EnvController controller = new EnvController(mockEnvironment);

        String profile = controller.getProfile();

        assertThat(profile).isEqualTo(expectedProfile);
    }

    @Test
    public void active_profile이_없으면_default가_조회된다() {

        String expectedProfile = "default";
        MockEnvironment mockEnvironment = new MockEnvironment();
        EnvController controller = new EnvController(mockEnvironment);

        String profile = controller.getProfile();

        assertThat(profile).isEqualTo(expectedProfile);

    }


}
