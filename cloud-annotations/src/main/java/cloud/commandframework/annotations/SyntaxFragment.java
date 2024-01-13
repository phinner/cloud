//
// MIT License
//
// Copyright (c) 2024 Incendo
//
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
//
// The above copyright notice and this permission notice shall be included in all
// copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
// SOFTWARE.
//
package cloud.commandframework.annotations;

import java.util.List;
import org.apiguardian.api.API;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Represents the fragment of the syntax making up a command.
 *
 * @since 1.7.0
 */
@API(status = API.Status.STABLE, since = "1.7.0")
public final class SyntaxFragment {

    private final String major;
    private final List<String> minor;
    private final ArgumentMode argumentMode;

    /**
     * Creates a new syntax fragment
     *
     * @param major        the major portion of the fragment
     * @param minor        the minor portions of the fragment
     * @param argumentMode the argument mode of the fragment
     */
    public SyntaxFragment(
            final @NonNull String major,
            final @NonNull List<@NonNull String> minor,
            final @NonNull ArgumentMode argumentMode
    ) {
        this.major = major;
        this.minor = minor;
        this.argumentMode = argumentMode;
    }

    /**
     * Returns the major portion of the fragment.
     *
     * <p>This is likely the name of an argument, or a string literal.</p>
     *
     * @return the major part of the fragment
     */
    public @NonNull String major() {
        return this.major;
    }

    /**
     * Returns the minor part of the fragment.
     *
     * <p>This is likely a list of aliases.</p>
     *
     * @return the minor part of the fragment.
     */
    public @NonNull List<@NonNull String> minor() {
        return this.minor;
    }

    /**
     * Returns the argument mode.
     *
     * @return the argument mode
     */
    public @NonNull ArgumentMode argumentMode() {
        return this.argumentMode;
    }
}
