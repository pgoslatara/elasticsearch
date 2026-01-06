/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the "Elastic License
 * 2.0", the "GNU Affero General Public License v3.0 only", and the "Server Side
 * Public License v 1"; you may not use this file except in compliance with, at
 * your election, the "Elastic License 2.0", the "GNU Affero General Public
 * License v3.0 only", or the "Server Side Public License, v 1".
 */

package org.elasticsearch.datastreams.lifecycle.steps;

// TODO: REMOVE BEFORE PR

import org.apache.logging.log4j.Logger;
import org.elasticsearch.cluster.ProjectState;
import org.elasticsearch.cluster.metadata.DataStream;
import org.elasticsearch.datastreams.lifecycle.DlmStep;

import java.util.Optional;

import static org.apache.logging.log4j.LogManager.getLogger;

/**
 * A no-op step used as a placeholder for testing.
 */
public class NoopStep implements DlmStep {

    private static final Logger logger = getLogger(NoopStep.class);
    private int itterCount = 0;

    @Override
    public boolean stepCompleted(DataStream dataStream, ProjectState projectState) {
        if (itterCount < 3) {
            itterCount++;
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void execute(DataStream dataStream, ProjectState projectState) {
        logger.info("Executing NoopStep for data stream: {}", dataStream.getName());
        // No-op
    }

    @Override
    public String stepDescription() {
        return "This step does absolutely nothing.";
    }

    @Override
    public Optional<Integer> maxConcurrency() {
        return Optional.empty();
    }
}
