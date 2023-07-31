package org.gt.Tools;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

public class CloudinaryConnection {
    private static Cloudinary cloudinary;

    private CloudinaryConnection() {

    }

    public static Cloudinary getInstance() {
        if (cloudinary == null) {

            String cloudName = "djbbxokgf";
            String apiKey = "918916159641163";
            String apiSecret = "Oy_VXRVpAnyfUnJyiPWQ4rRLhgU";

            cloudinary = new Cloudinary(ObjectUtils.asMap(
                    "cloud_name", cloudName,
                    "api_key", apiKey,
                    "api_secret", apiSecret
            ));
        }
        return cloudinary;
    }
}
