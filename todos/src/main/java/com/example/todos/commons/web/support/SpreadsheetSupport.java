package com.example.todos.commons.web.support;

import com.example.todos.commons.domain.Spreadsheet;
import com.example.todos.commons.util.StreamUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * {@link Spreadsheet} 보조 클래스
 *
 */
public interface SpreadsheetSupport {

    default Spreadsheet obtainSpreadsheet(Map<String, Object> model) {
        List<Spreadsheet> spreadsheets = model.values()
                .stream()
                .filter(it -> it instanceof Spreadsheet)
                .map(it -> (Spreadsheet) it)
                .toList();
        if (spreadsheets.isEmpty()) {
            throw new IllegalArgumentException("spreadsheet object inside the model is required");
        }
        if (spreadsheets.size() > 1) {
            throw new IllegalArgumentException("multiple spreadsheet objects were found");
        }
        return spreadsheets.get(0);
    }

    /**
     * 주어진 셀 목록에 값을 연결해서 하나의 문자열로 만듭니다.
     * 문자열 연결시 구분 문자를 삽입합니다.
     *
     * @param cells     반복자
     * @param delimiter 구분 문자
     * @return
     */
    default String joining(Iterable<Spreadsheet.Cell<?>> cells, CharSequence delimiter) {
        return StreamUtils.createStreamFromIterator(cells.iterator())
                .map(Spreadsheet.Cell::getValue)
                .map(String::valueOf)
                .collect(Collectors.joining(delimiter));
    }
}
