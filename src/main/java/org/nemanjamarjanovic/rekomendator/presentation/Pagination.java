package org.nemanjamarjanovic.rekomendator.presentation;

import java.util.List;

/**
 *
 * @author nemanja
 */
public class Pagination {

    private final List items;
    private final int size;
    private final int total;

    private int start;
    private int end;

    private int current = 1;
    private int last = 1;
    private boolean previous;
    private boolean next;

    public Pagination(List items, int size) {
        this.items = items;
        this.size = size;
        this.total = items.size();

        refresh();
    }

    public void previousPage() {
        this.current--;
        refresh();
    }

    public void nextPage() {
        this.current++;
        refresh();
    }

    private void refresh() {
        this.start = (this.current - 1) * this.size;
        this.end = start + this.size;
        end = (end > total) ? total : end;

        this.previous = this.current > 1;
        this.next = end < total;
        this.last = total / this.size;
        this.last = (total % this.size > 0) ? this.last + 1 : this.last;
        this.last = (this.last == 0) ? 1 : this.last;
    }

    public List getItems() {
        return this.items.subList(start, end);
    }

    public int getCurrent() {
        return current;
    }

    public int getLast() {
        return last;
    }

    public boolean isPrevious() {
        return previous;
    }

    public boolean isNext() {
        return next;
    }

}
