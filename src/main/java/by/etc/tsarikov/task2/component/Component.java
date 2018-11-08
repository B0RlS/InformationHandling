package by.etc.tsarikov.task2.component;

import java.util.List;

public interface Component {
    String take();

    List<Component> getComponent();
}
