package com.indeed.proctor.common.dynamic;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Preconditions;
import com.indeed.proctor.common.model.ConsumableTestDefinition;

public class TestNamePrefixFilter implements DynamicFilter {
    private final String prefix;

    /**
     * Construct the filter from test name prefix string
     * @param prefix prefix string matches the test names
     * @throws IllegalArgumentException if prefix is empty string
     */
    public TestNamePrefixFilter(@JsonProperty("prefix") final String prefix) {
        Preconditions.checkArgument(!prefix.isEmpty(), "Prefix should be non-empty string");
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }

    @Override
    public boolean matches(final String testName, final ConsumableTestDefinition testDefinition) {
        return testName.startsWith(prefix);
    }
}
