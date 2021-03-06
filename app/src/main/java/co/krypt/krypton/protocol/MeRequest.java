package co.krypt.krypton.protocol;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Nullable;

import co.krypt.krypton.pgp.UserID;

/**
 * Created by Kevin King on 12/3/16.
 * Copyright 2016. KryptCo, Inc.
 */

public class MeRequest extends RequestBody {
    public static final String FIELD_NAME = "me_request";

    @SerializedName("pgp_user_id")
    @Nullable
    public String pgpUserID;

    @SerializedName("u2f_only")
    @Nullable
    public Boolean u2fOnly;

    @Nullable
    public UserID userID() {
        if (pgpUserID == null) {
            return null;
        }
        return UserID.parse(pgpUserID);
    }

    @Override
    public <T, E extends Throwable> T visit(Visitor<T, E> visitor) throws E{
        return visitor.visit(this);
    }
}
