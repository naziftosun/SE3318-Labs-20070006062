package org.example;

public class MiddleEarthMap {
    public void navigate(String location, boolean isSecretPassage) {
        switch (location) {
            case "Mordor":
                System.out.println("Navigating to Mordor");
                if (isSecretPassage) {
                    System.out.println("Taking a secret passage");
                }
                break;
            case "Shire":
                System.out.println("Navigating to the Shire");
                // FallThrough violation - Missing break
            case "Gondor":
                System.out.println("Navigating to Gondor");
            default:
                System.out.println("Unknown location");
        }
        switch (location) {
            case "Lothlórien":
                System.out.println("Navigating to Lothlórien");
        }
        if (isSecretPassage) {
        }

        
        String result = isSecretPassage ? "Secret" : "Normal";
        System.out.println(result);
    }
}
