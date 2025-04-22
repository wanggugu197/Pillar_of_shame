package org.gte.gtecore.api.data.tag;

public interface ITagPrefix {

    default boolean gtecore$isTagInput() {
        return false;
    }
}
