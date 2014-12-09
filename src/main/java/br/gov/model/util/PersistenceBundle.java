package br.gov.model.util;

import java.util.ResourceBundle;

public class PersistenceBundle {
    private ResourceBundle bundle = null;

    public String getText(String key) {
        if (bundle == null) {
            bundle = ResourceBundle.getBundle("persistence_messages");
        }

        return bundle.getString(key);
    }
}
