//
// MIT License
//
// Copyright (c) 2021 Alexander Söderberg & Contributors
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
package cloud.commandframework.fabric.argument;

import cloud.commandframework.ArgumentDescription;
import cloud.commandframework.arguments.CommandArgument;
import cloud.commandframework.brigadier.argument.WrappedBrigadierParser;
import cloud.commandframework.context.CommandContext;
import java.util.List;
import java.util.function.BiFunction;
import net.minecraft.nbt.Tag;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * An argument for the string representation of an NBT {@link Tag}.
 *
 * @param <C> the sender type
 * @since 1.5.0
 */
public final class NbtTagArgument<C> extends CommandArgument<C, Tag> {

    NbtTagArgument(
            final boolean required,
            final @NonNull String name,
            final @NonNull String defaultValue,
            final @Nullable BiFunction<CommandContext<C>, String, List<String>> suggestionsProvider,
            final @NonNull ArgumentDescription<C> defaultDescription
    ) {
        super(
                required,
                name,
                new WrappedBrigadierParser<>(net.minecraft.commands.arguments.NbtTagArgument.nbtTag()),
                defaultValue,
                Tag.class,
                suggestionsProvider,
                defaultDescription
        );
    }

    /**
     * Create a new {@link Builder}.
     *
     * @param name Name of the component
     * @param <C>  Command sender type
     * @return Created builder
     * @since 1.5.0
     */
    public static <C> NbtTagArgument.@NonNull Builder<C> builder(final @NonNull String name) {
        return new NbtTagArgument.Builder<>(name);
    }

    /**
     * Create a new required {@link NbtTagArgument}.
     *
     * @param name Component name
     * @param <C>  Command sender type
     * @return Created argument
     * @since 1.5.0
     */
    public static <C> @NonNull NbtTagArgument<C> of(final @NonNull String name) {
        return NbtTagArgument.<C>builder(name).asRequired().build();
    }

    /**
     * Create a new optional {@link NbtTagArgument}.
     *
     * @param name Component name
     * @param <C>  Command sender type
     * @return Created argument
     * @since 1.5.0
     */
    public static <C> @NonNull NbtTagArgument<C> optional(final @NonNull String name) {
        return NbtTagArgument.<C>builder(name).asOptional().build();
    }

    /**
     * Create a new optional {@link NbtTagArgument} with the specified default value.
     *
     * @param name       Component name
     * @param defaultTag Default tag value
     * @param <C>        Command sender type
     * @return Created component
     * @since 1.5.0
     */
    public static <C> @NonNull NbtTagArgument<C> optional(final @NonNull String name, final @NonNull Tag defaultTag) {
        return NbtTagArgument.<C>builder(name).asOptionalWithDefault(defaultTag).build();
    }


    /**
     * Builder for {@link NbtTagArgument}.
     *
     * @param <C> sender type
     * @since 1.5.0
     */
    public static final class Builder<C> extends TypedBuilder<C, Tag, Builder<C>> {

        Builder(final @NonNull String name) {
            super(Tag.class, name);
        }

        /**
         * Build a new {@link NbtTagArgument}.
         *
         * @return Constructed component
         * @since 1.5.0
         */
        @Override
        public @NonNull NbtTagArgument<C> build() {
            return new NbtTagArgument<>(
                    this.isRequired(),
                    this.getName(),
                    this.getDefaultValue(),
                    this.getSuggestionsProvider(),
                    this.getDefaultDescription()
            );
        }

        /**
         * Sets the command argument to be optional, with the specified default value.
         *
         * @param defaultValue default value
         * @return this builder
         * @see CommandArgument.Builder#asOptionalWithDefault(String)
         * @since 1.5.0
         */
        public @NonNull Builder<C> asOptionalWithDefault(final @NonNull Tag defaultValue) {
            return this.asOptionalWithDefault(defaultValue.toString());
        }

    }

}
