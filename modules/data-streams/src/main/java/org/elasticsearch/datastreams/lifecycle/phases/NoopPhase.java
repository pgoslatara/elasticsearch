/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the "Elastic License
 * 2.0", the "GNU Affero General Public License v3.0 only", and the "Server Side
 * Public License v 1"; you may not use this file except in compliance with, at
 * your election, the "Elastic License 2.0", the "GNU Affero General Public
 * License v3.0 only", or the "Server Side Public License, v 1".
 */

package org.elasticsearch.datastreams.lifecycle.phases;

import org.elasticsearch.datastreams.lifecycle.DlmPhase;
import org.elasticsearch.datastreams.lifecycle.DlmStep;
import org.elasticsearch.datastreams.lifecycle.steps.NoopStep;

import java.util.List;

//TODO: REMOVE BEFORE PR
/**
 * A no-op phase used as a placeholder for testing.
 */
public class NoopPhase implements DlmPhase {
    @Override
    public String phaseName() {
        return "No-op Phase";
    }

    @Override
    public String schedulingIndexOption() {
        return "noop_after";
    }

    @Override
    public List<DlmStep> steps() {
        return List.of(new NoopStep());
    }
}
