/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Other licenses:
 * -----------------------------------------------------------------------------
 * Commercial licenses for this work are available. These replace the above
 * ASL 2.0 and offer limited warranties, support, maintenance, and commercial
 * database integrations.
 *
 * For more information, please visit: http://www.jooq.org/licenses
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package org.jooq.impl;

import org.jooq.Record;
import org.jooq.SQLDialect;
import org.jooq.Table;

/**
 * @author Lukas Eder
 */
final class TableDataType<R extends Record> extends DefaultDataType<R> {

    /**
     * Generated UID
     */
    private static final long serialVersionUID = 3262508265391094581L;

    @SuppressWarnings("unchecked")
    TableDataType(Table<R> table) {
        super(SQLDialect.DEFAULT, (Class<R>) table.getRecordType(), getQualifiedName(table));
    }

    private static String getQualifiedName(Table<?> table) {
        StringBuilder sb = new StringBuilder();

        if (table.getSchema() != null) {
            sb.append(table.getSchema().getName());
            sb.append(".");
        }

        sb.append(table.getName());
        return sb.toString();
    }
}
