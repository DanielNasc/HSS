package Utils;

import Errors.InvalidRequestException;

public class RequestTypesChecker {
    String[] payload;
    String[] payloadTypes;

    public RequestTypesChecker(String[] payload, String[] payloadTypes, int payloadSize) throws InvalidRequestException {
        if (payload.length != payloadSize) {
            throw new InvalidRequestException(correctFormat());
        }

        this.payload = payload;
        this.payloadTypes = payloadTypes;
    }    

    public String correctFormat() {
        String correctFormat = "";

        for (String type : payloadTypes) {
            correctFormat += type + ", ";
        }

        correctFormat = correctFormat.substring(0, correctFormat.length() - 2);

        return correctFormat;
    }

    public void runChecks() throws InvalidRequestException {
        if (!checkTypes()) {
            throw new InvalidRequestException(correctFormat());
        }
    }

    public boolean checkTypes() {
        if (payload.length != payloadTypes.length) {
            return false;
        }

        System.out.println("payload: " + payload.toString());
        for (int i = 0; i < payload.length; i++) {
            if (payload[i] == null) {
                return false;
            }

            switch(payloadTypes[i]) {
                case "any":
                    break;
                case "int":
                    try {
                        Integer.parseInt(payload[i]);
                    } catch (Exception e) {
                        return false;
                    }
                    break;
                case "string":
                    System.out.println(payload[i]);
                    if (payload[i].equals("")) {
                        return false;
                    }
                    break;
                case "date":
                    if (!CheckDate(payload[i])) {
                        return false;
                    }
                    break;
                case "double":
                    if (payload[i].equals("")) {
                        return false;
                    }
                case "boolean":
                    if (!payload[i].equals("true") && !payload[i].equals("false")) {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
        }


        return true;
    }

    public boolean CheckDate(String date) {
        String[] dateSplit = date.split("/");

        if (dateSplit.length != 3) {
            return false;
        }

        if (dateSplit[0].length() != 2 || dateSplit[1].length() != 2 || dateSplit[2].length() != 4) {
            return false;
        }

        try {
            Integer.parseInt(dateSplit[0]);
            Integer.parseInt(dateSplit[1]);
            Integer.parseInt(dateSplit[2]);
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
