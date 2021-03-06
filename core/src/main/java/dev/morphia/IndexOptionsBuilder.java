/*
 * Copyright 2016 MongoDB, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.morphia;

import dev.morphia.annotations.Collation;
import dev.morphia.annotations.Index;
import dev.morphia.annotations.IndexOptions;
import dev.morphia.annotations.Indexed;
import org.bson.Document;

import java.util.Map.Entry;

class IndexOptionsBuilder extends AnnotationBuilder<IndexOptions> implements IndexOptions {
    IndexOptionsBuilder() {
    }

    IndexOptionsBuilder(IndexOptions original, String prefix) {
        super(original);
        if (!"".equals(original.partialFilter())) {
            final Document parse = Document.parse(original.partialFilter());
            final Document filter = new Document();
            for (Entry<String, Object> entry : parse.entrySet()) {
                filter.put(prefix + "." + entry.getKey(), entry.getValue());
            }
            partialFilter(filter.toJson());
        }
    }

    @Override
    public Class<IndexOptions> annotationType() {
        return IndexOptions.class;
    }

    @Override
    public boolean background() {
        return get("background");
    }

    @Override
    public boolean disableValidation() {
        return get("disableValidation");
    }

    @Override
    public int expireAfterSeconds() {
        return get("expireAfterSeconds");
    }

    @Override
    public String language() {
        return get("language");
    }

    @Override
    public String languageOverride() {
        return get("languageOverride");
    }

    @Override
    public String name() {
        return get("name");
    }

    @Override
    public boolean sparse() {
        return get("sparse");
    }

    @Override
    public boolean unique() {
        return get("unique");
    }

    @Override
    public String partialFilter() {
        return get("partialFilter");
    }

    @Override
    public Collation collation() {
        return get("collation");
    }

    IndexOptionsBuilder background(boolean background) {
        put("background", background);
        return this;
    }

    IndexOptionsBuilder disableValidation(boolean disableValidation) {
        put("disableValidation", disableValidation);
        return this;
    }

    IndexOptionsBuilder expireAfterSeconds(int expireAfterSeconds) {
        put("expireAfterSeconds", expireAfterSeconds);
        return this;
    }

    IndexOptionsBuilder language(String language) {
        put("language", language);
        return this;
    }

    IndexOptionsBuilder languageOverride(String languageOverride) {
        put("languageOverride", languageOverride);
        return this;
    }

    IndexOptionsBuilder name(String name) {
        put("name", name);
        return this;
    }

    IndexOptionsBuilder sparse(boolean sparse) {
        put("sparse", sparse);
        return this;
    }

    IndexOptionsBuilder unique(boolean unique) {
        put("unique", unique);
        return this;
    }

    IndexOptionsBuilder partialFilter(String partialFilter) {
        put("partialFilter", partialFilter);
        return this;
    }

    IndexOptionsBuilder collation(Collation collation) {
        put("collation", collation);
        return this;
    }

    IndexOptionsBuilder migrate(Index index) {
        putAll(toMap(index));
        return this;
    }

    IndexOptionsBuilder migrate(Indexed index) {
        putAll(toMap(index));
        return this;
    }
}
