package io.getarrays.securecapita.domain;

import java.util.Objects;

public class Page {


    private final long page;

    private final long size;

    public Page(long page, long size) {
        this.page = page;
        this.size = size;
    }

    public long getLimit() {
        return size;
    }

    public long getOffset() {
        return (page - 1) * size;
    }

    public io.getarrays.securecapita.domain.Page next() {
        return io.getarrays.securecapita.domain.Page.of(page + 1, size);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        io.getarrays.securecapita.domain.Page page1 = (io.getarrays.securecapita.domain.Page) o;
        return page == page1.page && size == page1.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(page, size);
    }

    @Override
    public String toString() {
        return "Page{" + "page=" + page + ", size=" + size + '}';
    }

    public static io.getarrays.securecapita.domain.Page of(long page, long size) {
        if (page <= 0) {
            throw new IllegalArgumentException("The page cannot be either zero or negative");
        } else if (size <= 0) {
            throw new IllegalArgumentException("The size cannot be either zero or negative");
        }
        return new io.getarrays.securecapita.domain.Page(page, size);


}}
